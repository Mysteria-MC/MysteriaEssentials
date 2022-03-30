package net.mysteria.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mysteria.essentials.main.Main;

public class Vanish implements CommandExecutor {
	
	public Vanish(Main plugin) {
		plugin.getCommand("vanish").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDieser Command ist nur für Spieler");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!(player.hasPermission("mysterial.essentials.vanish"))) {
			player.sendMessage("§cDu hast nicht die benötigte Berechtigung um diesen Command auszuführen");
			return false;
		}
		
		if(args.length > 0) {
			player.sendMessage("§cDieser Command lässt keine Argumente zu");
			return false;
		}
		
		if(player.isInvisible()) {
			player.setInvisible(false);
			for(Player other : Bukkit.getServer().getOnlinePlayers()) {
				other.showPlayer(player);
			}
		} else if(!(player.isInvisible())) {
			player.setInvisible(true);
			for(Player other : Bukkit.getServer().getOnlinePlayers()) {
				other.hidePlayer(player);
			}
			return true;
		}
		
		return false;
	}

}
