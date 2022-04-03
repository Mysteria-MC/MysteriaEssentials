package net.mysteria.essentials.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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
	
}
