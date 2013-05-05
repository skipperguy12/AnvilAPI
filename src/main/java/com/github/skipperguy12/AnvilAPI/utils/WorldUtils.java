package com.github.skipperguy12.AnvilAPI.utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import com.github.skipperguy12.AnvilAPI.Travel.NullChunkGenerator;
import com.github.skipperguy12.AnvilAPI.core.AnvilAPICore;

public class WorldUtils {
	AnvilAPICore plugin;

	public WorldUtils(AnvilAPICore plugin) {
		this.plugin = plugin;
	}

	/**
	 * Attempts to unload a world
	 * 
	 * @param world
	 *            The world to unload
	 */
	public void unloadMap(String world) {

		if (Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(world), false)) {
			plugin.getLogger().info("Successfully unloaded " + world);
		} else {
			plugin.getLogger().severe("COULD NOT UNLOAD " + world);
		}
	}

	/**
	 * Loads a world
	 * 
	 * @param world
	 *            The world to load, the world will be created if it does not
	 *            exist
	 */
	public boolean loadMap(String world) {
		File file = new File(Bukkit.getServer().getWorldContainer(), world);

		if (file.exists()) {
			Bukkit.getServer().createWorld(new WorldCreator(world));
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Undoes everything to the world till the last /save-all of the server
	 * 
	 * @param world
	 *            The world to roll back
	 */
	public void rollback(String world) {
		unloadMap(world);
		loadMap(world);
	}

	/**
	 * Generates a new world
	 * 
	 * @param name
	 *            Name of the world
	 * @param empty
	 *            Should the world be empty? true is yes, false is no
	 */
	public void generateWorld(String name, boolean empty) {
		Bukkit.getServer().createWorld(empty ? new WorldCreator(name).generator(new NullChunkGenerator()).generateStructures(false) : new WorldCreator(name));

	}

}
