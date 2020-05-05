public class YourMainClass extends JavaPlugin {

	
	@Override
	public void onEnable() {
		
		validatePlayers();
	}
	
	@Override
	public void onDisable() {
		invalidatePlayers();
		Bukkit.getScheduler().cancelTasks(this);
	}
  
	}
	
	public void validatePlayers() {
		if(!Bukkit.getOnlinePlayers().isEmpty()) {
			for(Player p : Bukkit.getOnlinePlayers()) {
				PacketReader reader = new PacketReader();
				reader.inject(p);
			}
		}
	}
	
	public void invalidatePlayers() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			PacketReader reader = new PacketReader();
			reader.uninject(p);
		}
	}
