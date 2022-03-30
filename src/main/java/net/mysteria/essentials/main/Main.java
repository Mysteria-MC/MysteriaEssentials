package net.mysteria.essentials.main;

import org.bukkit.plugin.java.JavaPlugin;

import net.mysteria.essentials.commands.GMode;
import net.mysteria.essentials.commands.Vanish;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		new GMode(this);
		new Vanish(this);
		
	}
	
}
