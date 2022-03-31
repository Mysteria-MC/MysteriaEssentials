package net.mysteria.essentials.main;

import org.bukkit.plugin.java.JavaPlugin;

import net.mysteria.essentials.commands.GMode;
import net.mysteria.essentials.commands.Vanish;
import net.mysteria.essentials.commands.InvSee;
import net.mysteria.essentials.commands.Info;
import net.mysteria.essentials.commands.Spectate;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		new GMode(this);
		new Vanish(this);
		new InvSee(this);
		new Spectate(this);
		
		
	}
	
}
