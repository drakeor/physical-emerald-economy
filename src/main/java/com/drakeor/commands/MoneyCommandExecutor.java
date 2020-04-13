package com.drakeor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.drakeor.economy.EmeraldEconomy;

public class MoneyCommandExecutor implements CommandExecutor {

	private final EmeraldEconomy economy;
	
	public MoneyCommandExecutor(EmeraldEconomy plugin) {
		this.economy = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
	        Player player = (Player) sender;
	        sender.sendMessage("Total Emeralds: " + this.economy.getEmeraldInventory(player));
	        // do something
	    } else {
	        sender.sendMessage("You must be a player!");
	        return false;
	    }
	    // do something
	    return false;
	}
	
}