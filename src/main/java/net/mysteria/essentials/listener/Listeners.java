package net.mysteria.essentials.listener;

import java.time.LocalDate;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.mysteria.essentials.model.PlayerInfoModel;
import net.mysteria.essentials.service.PlayerInfoService;

public class Listeners implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if(!(event.getWhoClicked() instanceof Player)) {
			return;
		}
		
		Player player = (Player) event.getWhoClicked();
		
		if(!(player.getInventory().equals(event.getClickedInventory()))) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(!(player.hasPlayedBefore())) {
			
			PlayerInfoModel model = new PlayerInfoModel();
			model.setFirstTimeSeen(LocalDate.now().toString());
			model.setUsername(player.getName());
			model.setLastTimeSeen(LocalDate.now().toString());
			
			PlayerInfoService.addPlayerInfo(model);
			
			player.sendTitle("§aHerzlich willkommen auf dem Server", "Du bist zum ersten mal hier");
			
		}
		
		player.sendTitle("§aHerzlich Willkommen", null);
		
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		
		PlayerInfoService.updateLastTimeSeen(player.getName(), LocalDate.now().toString());
		
	}
	
}
