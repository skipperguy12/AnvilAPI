package com.github.skipperguy12.AnvilAPI.AnvilCMD.commands;

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

public class BackCommand extends Commands implements CommandExecutor {
	AnvilAPICore plugin;

	public BackCommand(AnvilAPICore plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("back")) {
				if (plugin.AnvilCMD.getBackLocation(p) == null)
					p.sendMessage(ChatColor.RED + "You must define your /back location by either travelling to a world or using /setback!");
				else {
					plugin.AnvilCMD.setBackLocation(p, p.getLocation());
					p.teleport(plugin.AnvilCMD.getBackLocation(p));
				}
			} else if (cmd.getName().equalsIgnoreCase("setback")) {
				plugin.AnvilCMD.setBackLocation(p, p.getLocation());
				p.sendMessage(ChatColor.RED + "/back location saved, type /back to return here!");
			}

		}

		return true;
	}
}
