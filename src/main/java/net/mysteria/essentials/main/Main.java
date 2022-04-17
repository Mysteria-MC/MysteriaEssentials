package net.mysteria.essentials.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.mysteria.essentials.commands.GMode;
import net.mysteria.essentials.commands.Vanish;
import net.mysteria.essentials.configuration.PersistenceXMLConfig;
import net.mysteria.essentials.commands.InvSee;
import net.mysteria.essentials.commands.Spectate;
import net.mysteria.essentials.commands.Info;
import net.mysteria.essentials.listener.Listeners;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		loadConfig();
		
//		PersistenceXMLConfig persistenceXMLConfig = PersistenceXMLConfig.getInstance(this);
//		persistenceXMLConfig.writePersistenceXML();
		
		new GMode(this);
		new Vanish(this);
		new InvSee(this);
		new Spectate(this);
		new Info(this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		
	}
	
	private void loadConfig() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();
	}
	
}
