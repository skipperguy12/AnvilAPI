package com.github.skipperguy12.AnvilAPI.AnvilCMD.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.github.skipperguy12.AnvilAPI.core.AnvilAPICore;

public class PlayerDeathListener implements Listener {
	AnvilAPICore plugin;

	public PlayerDeathListener(AnvilAPICore plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		plugin.AnvilCMD.setBackLocation(player, player.getLocation());
	}

}
