package net.mysteria.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mysteria.essentials.main.Main;

public class Spectate implements CommandExecutor {
	
	public Spectate(Main plugin) {
		plugin.getCommand("spectate").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDieser Command ist nur für Spieler");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!(player.hasPermission("mysteria.essentials.spectate"))) {
			player.sendMessage("§cDu hast nicht die benötigten Rechte um diesen Command auszuführen");
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage("§cDu musst einen Spieler angeben dem du zuschauen möchtest");
			return false;
		}
		
		Player target = Bukkit.getPlayerExact(args[0]);
		
		if(!(target instanceof Player)) {
			player.sendMessage("§cDer angegebene Spieler ist nicht auf diesem Server");
			return false;
		}
		
		
		
		return false;
		
	}

}
