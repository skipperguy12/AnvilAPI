package com.github.skipperguy12.AnvilAPI.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.github.skipperguy12.AnvilAPI.core.AnvilAPICore;

public class ConfigurationalParser {
	AnvilAPICore plugin;

	public ConfigurationalParser(AnvilAPICore plugin) {

	}

	/**
	 * 
	 * Saves a location to a single line in config
	 * 
	 * @param l
	 *            The location
	 * @param y
	 *            The yaw
	 * @param p
	 *            The pitch
	 * @return The location formatted as a String (parsable by stringToLoc())
	 */
	public String locToString(Location l, float y, float p) {
		String location = (l.getWorld().getName() + ":" + l.getX() + ":" + l.getY() + ":" + l.getZ() + ":" + y + ":" + p);
		return location;
	}

	/**
	 * A parser that can convert a String into a Location
	 * 
	 * @param s
	 *            The string (creatable by locToString())
	 * @return The location
	 */
	public Location stringToLoc(String s) {

		String[] loc = s.split(":");
		World world = Bukkit.getWorld(loc[0]);
		Double x = Double.parseDouble(loc[1]);
		Double y = Double.parseDouble(loc[2]);
		Double z = Double.parseDouble(loc[3]);
		double yaw = Double.parseDouble(loc[4]);
		double pitch = Double.parseDouble(loc[5]);
		Location finalloc = new Location(world, x, y, z);
		finalloc.setPitch((float) pitch);
		finalloc.setYaw((float) yaw);
		return finalloc;
	}

}
