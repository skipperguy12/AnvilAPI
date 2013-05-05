package com.github.skipperguy12.AnvilAPI.core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.skipperguy12.AnvilAPI.AnvilCMD.AnvilCMD;
import com.github.skipperguy12.AnvilAPI.utils.ConfigurationalParser;
import com.github.skipperguy12.AnvilAPI.utils.WorldUtils;
import com.github.skipperguy12.AnvilAPI.Travel.commands.TravelCommand;
import com.github.skipperguy12.AnvilAPI.AnvilCMD.commands.BackCommand;
import com.github.skipperguy12.AnvilAPI.AnvilCMD.listeners.PlayerDeathListener;

public class AnvilAPICore extends JavaPlugin {
	public BackCommand BackCommand;
	public TravelCommand TravelCommand;

	public AnvilCMD AnvilCMD;
	public WorldUtils WorldUtils;
	ConfigurationalParser configParser;

	public void onEnable() {

		AnvilCMD = new AnvilCMD(this);
		WorldUtils = new WorldUtils(this);
		configParser = new ConfigurationalParser(this);
		// Listeners
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
		// Commands for Travel
		TravelCommand = new TravelCommand(this);
		getCommand("travel").setExecutor(TravelCommand);
		// Commands for AnvilCMD
		BackCommand = new BackCommand(this);
		getCommand("setback").setExecutor(BackCommand);
		getCommand("back").setExecutor(BackCommand);
	}

	public void onDisable() {

	}

}
