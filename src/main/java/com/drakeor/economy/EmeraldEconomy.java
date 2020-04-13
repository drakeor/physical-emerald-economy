package com.drakeor.economy;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.drakeor.commands.MoneyCommandExecutor;

import net.milkbowl.vault.economy.EconomyResponse;

public final class EmeraldEconomy extends JavaPlugin
{
	public static EmeraldEconomy economyInstance;
	public EmeraldEconomyVault emeraldEconomyVault;
	private VaultHook vaultHook;
	
	@Override
    public void onEnable() {
		
		// Assign static instance to this and create data folder
		economyInstance = this;
		if (!getDataFolder().exists()) {
		    getDataFolder().mkdirs();
		}
		
		// Start plugin and hook into vault
		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
			emeraldEconomyVault = new EmeraldEconomyVault();
		    vaultHook = new VaultHook();
		    vaultHook.hook();
		}
		
		// Assign commands
		this.getCommand("money").setExecutor(new MoneyCommandExecutor(this));
		
		Bukkit.getLogger().warning("[PhysicalEmeraldEconomy] Plugin loaded.");
    }

    @Override
    public void onDisable() {
    	if (Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
    	    vaultHook.unhook();
    	}
    	Bukkit.getLogger().warning("[PhysicalEmeraldEconomy] Plugin unloaded.");
    }
    
    
    // Get emeralds from the player's inventory
    public int getEmeraldInventory(Player player)
    {
    	if(player == null)
    		return 0;
    	
    	PlayerInventory playerInv = player.getInventory();
    	ItemStack[] items = playerInv.getContents();
    	int totalAmount = 0;
    	for(ItemStack item : items)
    	{
    		// Only count emeralds for now
    		// We'll count emerald blocks later.
    		if(item != null && item.getType() == Material.EMERALD)
    		{
    			totalAmount += item.getAmount();
    		}
    	}
    	return totalAmount;
    }
    
    // Check if the player has enough emeralds in their inventory
    public boolean playerHasEnough(Player player, int amount)
    {
    	// Only works on valid players
    	if(player == null)
    		return false;
    	
    	// Make sure the player has enough
    	int playerEmeralds = this.getEmeraldInventory(player);
    	if(playerEmeralds < amount)
    		return false;
    	
    	return true;
    }
    
    // Withdraw emeralds from the player's inventory
    public boolean takeEmeraldsFromPlayer(Player player, int amount)
    {
    	// Only works on valid players
    	if(player == null)
    		return false;
    	
    	// Make sure the player has enough
    	if (!this.playerHasEnough(player, amount))
    		return false;
    	
    	PlayerInventory playerInv = player.getInventory();
    	ItemStack[] items = playerInv.getContents();
    	int amountLeft = amount;
    	for(ItemStack item : items)
    	{
    		// Only count emeralds for now
    		// We'll count emerald blocks later.
    		if(item != null && item.getType() == Material.EMERALD)
    		{
    			amountLeft -= item.getAmount();
    			playerInv.remove(item);
    		}
    	}
    	
    	// If we took too much, refund the player
    	if(amountLeft < 0) {
    		playerInv.addItem(new ItemStack(Material.EMERALD, -amountLeft));
    	}
    	return true;
    }
    
    // Give emeralds to a player
    public boolean giveEmeraldsToPlayer(Player player, int amount)
    {
    	// Only works on valid players
    	if(player == null)
    		return false;

    	
    	PlayerInventory playerInv = player.getInventory();
    	HashMap<Integer, ItemStack> leftOver = playerInv.addItem(new ItemStack(Material.EMERALD, amount));
    	if(!leftOver.isEmpty())
    	{
        	int amountLeft = leftOver.get(0).getAmount();
        	while(amountLeft > 0)
        	{
        		int amountToGive = amountLeft;
        		if(amountToGive > playerInv.getMaxStackSize()) {
        			amountToGive = playerInv.getMaxStackSize();
        		}
        		player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.EMERALD, amountToGive));
        		amountLeft -= amountToGive;
        	}
    	}

    	return true;
    }
    
    // Generic withdraw expression.
    // Some of the mods I used were trying to withdraw from an online player using the offline code.
    public EconomyResponse withdrawPlayer(String playerName, double amount)
    {
    	int intAmount = (int) Math.ceil(amount);
    	Player player = Bukkit.getPlayer(playerName);
    	
    	if(player == null) {
    		return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "Cannot find online player " + playerName);
    	}
    	
    	if(!takeEmeraldsFromPlayer(player, intAmount))
    	{
    		return new EconomyResponse(amount, getEmeraldInventory(player), EconomyResponse.ResponseType.FAILURE, "Could not withdraw " + intAmount + " from player " + playerName);
    	}
    	
    	return new EconomyResponse(amount, getEmeraldInventory(player), EconomyResponse.ResponseType.SUCCESS, "");
    }
    
    
    public EconomyResponse depositPlayer(String playerName, double amount)
    {
    	int intAmount = (int) Math.floor(amount);
		Player player = Bukkit.getPlayer(playerName);
    	
    	if(player == null) {
    		return new EconomyResponse(amount, 0, EconomyResponse.ResponseType.FAILURE, "Cannot find online player " + playerName);
    	}
    	
    	if(!giveEmeraldsToPlayer(player, intAmount))
    	{
    		return new EconomyResponse(amount, getEmeraldInventory(player), EconomyResponse.ResponseType.FAILURE, "Could not deposit " + intAmount + " to player " + playerName);
    	}
    	
    	return new EconomyResponse(amount, getEmeraldInventory(player), EconomyResponse.ResponseType.SUCCESS, "");
    }
    
}