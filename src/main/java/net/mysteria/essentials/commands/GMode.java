package net.mysteria.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mysteria.essentials.main.Main;

public class GMode implements CommandExecutor {
	
	public GMode(Main plugin) {
		plugin.getCommand("gm").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDieser Command kann nur von Spielern ausgeführt werden");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!(player.hasPermission("mysteria.essentials.gamemode"))) {
			player.sendMessage("§cDu hast nicht die benötigten Rechte um dies zu tun");
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage("§cDu musst einen GameMode angeben in den du wechseln möchtest");
			return false;
		}
		
		int gameMode = Integer.parseInt(args[0]);
		
		switch(gameMode) {
		
		case 0:
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage("§aDein Spielmodus wurde erfolgreich auf Überleben gesetzt");
			return true;
		
		case 1:
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage("§aDein Spielmodus wurde erfolgreich auf Kreativ gesetzt");
			return true;
			
		case 2:
			player.setGameMode(GameMode.ADVENTURE);
			player.sendMessage("§aDein Spielmodus wurde erfolgreich auf Abenteuer gesetzt");
			return true;
		
		case 3:
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("§aDein Spielmodus wurde erfolgreich auf Zuschauer gesetzt");
			return true;
		
		}
		
		return false;
		
	}

}
