package net.mysteria.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_11_R1.PacketPlayOutCamera;
import net.minecraft.server.v1_11_R1.PlayerConnection;
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
		
		if(args[0].equalsIgnoreCase("leave")) {
			PacketPlayOutCamera cam = new PacketPlayOutCamera();
			
			cam.a = player.getEntityId();
			
			((CraftPlayer)player).getHandle().playerConnection.sendPacket(cam);
			
			player.setGameMode(GameMode.CREATIVE);
			
			player.sendMessage("§aDu hast den Spectator Modus verlassen");
			
			return true;
		}
		
		Player target = Bukkit.getPlayerExact(args[0]);
		
		if(!(target instanceof Player)) {
			player.sendMessage("§cDas angegebene Ziel ist kein Spieler");
			return false;
		}
		
		if(!(target.isOnline())) {
			player.sendMessage("§cDer angegebene Spieler ist zur Zeit nicht online");
			return false;
		}
		
		player.setGameMode(GameMode.SPECTATOR);
		
		PacketPlayOutCamera cam = new PacketPlayOutCamera();
		cam.a = target.getEntityId();
		
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(cam);
		
		player.sendMessage("§aDu schaust jetzt " + target.getName() + " zu");
		
		return true;
		
	}

}
