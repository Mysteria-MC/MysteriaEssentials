package net.mysteria.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mysteria.essentials.main.Main;
import net.mysteria.essentials.model.PlayerInfoModel;
import net.mysteria.essentials.service.PlayerInfoService;

public class Info implements CommandExecutor {
	
	public Info(Main plugin) {
		plugin.getCommand("info").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender.hasPermission("mysteria.essential.info"))) {
			sender.sendMessage("§cDu hast nicht die benÃ¶tigte Berechtigung um diesen Command auszuführen");
			return false;
		}
		
		if(args.length < 1) {
			sender.sendMessage("§cDu musst einen Spieler angeben dessen Infos du abrufen möchtest");
			return false;
		}
		
		Player target = Bukkit.getPlayerExact(args[0]);
		
		if(!(target instanceof Player)) {
			sender.sendMessage("§cDer angegebene Spieler konnt nicht gefunden werden");
			return false;
		}
		
		PlayerInfoModel model = PlayerInfoService.getPlayerByUsername(target.getName());
		
		String firstTimeSeen = model.getFirstTimeSeen();
		String lastTimeSeen = model.getLastTimeSeen();
		int ping = target.getPing();
		String ip = target.getAddress().getHostName();
		
		sender.sendMessage(ChatColor.GREEN + "Informationenen über "+ ChatColor.BLUE + target.getName() + ChatColor.GOLD + "\nBeigetreten am: " + ChatColor.DARK_RED + firstTimeSeen + ChatColor.GOLD + "\nZuletzt gesehen am: " + ChatColor.DARK_RED + lastTimeSeen + ChatColor.GOLD + "\nIP: " + ChatColor.DARK_RED +  ip + ChatColor.GOLD + " Ping: "+ ChatColor.DARK_RED + ping);
		
		return true;
	}

}
