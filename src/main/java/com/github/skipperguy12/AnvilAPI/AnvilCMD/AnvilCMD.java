package com.github.skipperguy12.AnvilAPI.AnvilCMD;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.skipperguy12.AnvilAPI.core.AnvilAPICore;

/**
 * Class to handle AnvilCMD
 * 
 * @author Neiljohari
 * 
 */
public class AnvilCMD {
	private HashMap<Player, Location> backLocation = new HashMap<Player, Location>();
	AnvilAPICore plugin;

	public AnvilCMD(AnvilAPICore plugin) {
		this.plugin = plugin;
	}

	/**
	 * Set's the location for a player to /back to
	 * 
	 * @param player
	 *            Player who's /back location will be changed
	 * @param location
	 *            The location of where the player will go when they type /back
	 */
	public void setBackLocation(Player player, Location location) {
		this.backLocation.put(player, location);
	}

	/**
	 * Get a player's /back location
	 * 
	 * @param player
	 *            The player to get the /back location from
	 * @return The player's /back location
	 */
	public Location getBackLocation(Player player) {
		return this.backLocation.get(player);
	}

}
