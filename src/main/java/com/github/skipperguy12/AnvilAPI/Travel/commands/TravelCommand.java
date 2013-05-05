package com.github.skipperguy12.AnvilAPI.Travel.commands;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.skipperguy12.AnvilAPI.commands.Commands;
import com.github.skipperguy12.AnvilAPI.core.AnvilAPICore;

public class TravelCommand extends Commands implements CommandExecutor {
	AnvilAPICore plugin;

	public TravelCommand(AnvilAPICore plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("travel")) {
				if (args.length == 0) { // Typed: /travel
					p.sendMessage("Travel Core Command, type /travel view to see all worlds, and /travel help to view help!");

				} else if (args.length == 1) { // Typed: /travel <something>
					if (args[0].equalsIgnoreCase("view")) { // Display all
															// worlds
						SortedMap<Integer, String> worlds = new TreeMap<Integer, String>(Collections.reverseOrder());
						for (int i = 0; i < Bukkit.getWorlds().size(); i++) {
							worlds.put(i + 1, Bukkit.getWorlds().get(i).getName());
						}
						paginate(sender, worlds, 1, 5);

					} else if (args[0].equalsIgnoreCase("help")) { // Display
																	// all sub
																	// commands
						SortedMap<Integer, String> commands = new TreeMap<Integer, String>(Collections.reverseOrder());
						commands.put(1, "/travel load <worldname> - Loads a world");
						commands.put(2, "/travel unload <worldname> - Unloads a world");
						commands.put(3, "/travel rollback <worldname> - Rolls back a world");
						commands.put(4, "/travel generate <new/null> <worldname> - Generate a new or null world");
						paginate(sender, commands, 1, 5);

					} else if (args[0].equalsIgnoreCase("setspawn")) {
						p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
						p.sendMessage(ChatColor.RED + "World " + p.getWorld().getName() + "'s spawn location set to x:" + p.getLocation().getBlockX() + " y:" + p.getLocation().getBlockY() + " z:" + p.getLocation().getBlockZ());
					} else {
						plugin.AnvilCMD.setBackLocation(p, p.getLocation());
						for (World w : Bukkit.getWorlds()) {
							if (w.getName().equalsIgnoreCase(args[0])) {

								p.teleport(w.getSpawnLocation());
							}

						}
					}
				} else if (args.length == 2) { // Typed: /travel <something>
												// <something>
					if (args[0].equalsIgnoreCase("help")) { // Display
						// all sub
						// commands
						SortedMap<Integer, String> commands = new TreeMap<Integer, String>(Collections.reverseOrder());
						commands.put(1, "/travel load <worldname> - Loads a world");
						commands.put(2, "/travel unload <worldname> - Unloads a world");
						commands.put(3, "/travel rollback <worldname> - Rolls back a world");
						commands.put(4, "/travel generate <new/null> <worldname> - Generate a new or null world");
						paginate(sender, commands, Integer.parseInt(args[1]), 5);

					}
					if (args[0].equalsIgnoreCase("load")) {
						boolean loaded = plugin.WorldUtils.loadMap(args[1]);
						if (loaded) {
							p.sendMessage(ChatColor.RED + args[1] + " has been loaded!");
							plugin.WorldUtils.loadMap(args[1]);
						} else {
							p.sendMessage(ChatColor.RED + "World folder did not exist!");
						}

					} else if (args[0].equalsIgnoreCase("unload")) {
						plugin.WorldUtils.unloadMap(args[1]);
					} else if (args[0].equalsIgnoreCase("rollback")) {
						plugin.WorldUtils.rollback(args[1]);
					}

				} else if (args.length == 3) { // Typed: Travel <something>
												// <something> <something>
					if (args[0].equalsIgnoreCase("generate")) {
						if (args[1].equalsIgnoreCase("new")) {
							plugin.WorldUtils.generateWorld(args[2], false);
						} else if (args[1].equalsIgnoreCase("null")) {
							plugin.WorldUtils.generateWorld(args[2], true);
						}
					}

				}
			}
		}

		return true;
	}
}
