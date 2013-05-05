package com.github.skipperguy12.AnvilAPI.commands;

import java.util.Map.Entry;
import java.util.SortedMap;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Commands {
	/**
	 * Pagination by Gomeow
	 * 
	 * @param sender
	 *            The commandsender to paginate to
	 * @param map
	 *            SortedMap of what to paginate
	 * @param page
	 *            Starting page
	 * @param pageLength
	 *            Amount to display per that page
	 */
	public void paginate(CommandSender sender, SortedMap<Integer, String> map, int page, int pageLength) {
		sender.sendMessage(ChatColor.YELLOW + "List: Page (" + String.valueOf(page) + " of " + (((map.size() % pageLength) == 0) ? map.size() / pageLength : (map.size() / pageLength) + 1));
		int i = 0, k = 0;
		page--;
		for (final Entry<Integer, String> e : map.entrySet()) {
			k++;
			if ((((page * pageLength) + i + 1) == k) && (k != ((page * pageLength) + pageLength + 1))) {
				i++;
				sender.sendMessage(ChatColor.YELLOW + " - " + e.getValue());
			}
		}
	}

}
