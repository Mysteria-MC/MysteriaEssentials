package net.mysteria.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mysteria.essentials.main.Main;

public class InvSee implements CommandExecutor {
	
	public InvSee(Main plugin) {
		plugin.getCommand("invsee").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("�cDieser Command ist nur f�r Spieler");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!(player.hasPermission("mysteria.essentials.invsee"))) {
			player.sendMessage("�cDu hast nicht die ben�tigte Berechtigung um diesen Command auszuf�hren");
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage("�cDu musst einen Spieler angeben dessen Inventar du sehen m�chtest");
			return false;
		}
		
		Player target = Bukkit.getPlayerExact(args[0]);
		
		if(!(target instanceof Player)) {
			player.sendMessage("�cDas angegebene Ziel ist kein Spieler");
			return false;
		}
		
		if(!(target.isOnline())) {
			player.sendMessage("�cDer angegebene Spieler ist zur Zeit nicht online");
			return false;
		}
		
		player.openInventory(target.getInventory());
		
		return true;
		
	}

}
