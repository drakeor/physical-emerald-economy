package com.drakeor.economy;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

class EmeraldEconomyVault implements Economy
{
    private EmeraldEconomy economy = EmeraldEconomy.economyInstance;
    
	public boolean isEnabled() {
		if (economy == null) {
		    return false;
		}
	    return true;
	}


	// No bank support
	public boolean hasBankSupport() {
		return false;
	}

	/*
	 * Formatting stuff
	 */
	// We have no fractional digits
	public int fractionalDigits() {
		return -1;
	}
	public String getName() {
		return "PhysicalEmeraldEconomy";
	}

	public String format(double amount) {
		return amount + " E";
	}

	public String currencyNamePlural() {
		return "Emeralds";
	}

	public String currencyNameSingular() {
		return "Emerald";
	}

	/*
	 * Online players have accounts, offline players do not.
	 */
	public boolean hasAccount(String playerName) {
		return true;
	}
	public boolean hasAccount(OfflinePlayer player) {
		return false;
	}
	public boolean hasAccount(String playerName, String worldName) {
		return true;
	}
	public boolean hasAccount(OfflinePlayer player, String worldName) {
		return false;
	}

	/*
	 * Calculate balance for players
	 * Only online players are counted
	 */
	private double getBalanceHelper(String playerName) {
		Player player = Bukkit.getPlayer(playerName);
		if(player != null) {
			return economy.getEmeraldInventory(player);
		}
		return 0;
	}
	public double getBalance(String playerName) {
		return this.getBalanceHelper(playerName);    	   	
	}

	public double getBalance(OfflinePlayer player) {
		return this.getBalanceHelper(player.getName());
	}

	public double getBalance(String playerName, String world) {
		return this.getBalanceHelper(playerName);    
	}

	public double getBalance(OfflinePlayer player, String world) {
		return this.getBalanceHelper(player.getName());
	}

	/*
	 * Check if the player has enough emeralds.
	 * Again, exclude offline players.
	 */
	public boolean hasHelper(String playerName, double amount) {
		Player player = Bukkit.getPlayer(playerName);
		int amountInt = (int) Math.ceil(amount);
		if(player != null) {
			return economy.playerHasEnough(player, amountInt);
		}
		return false;
	}
	public boolean has(String playerName, double amount) {
		// TODO Auto-generated method stub
		return this.hasHelper(playerName, amount);
	}

	public boolean has(OfflinePlayer player, double amount) {
		// TODO Auto-generated method stub
		return this.hasHelper(player.getName(), amount);
	}

	public boolean has(String playerName, String worldName, double amount) {
		// TODO Auto-generated method stub
		return this.hasHelper(playerName, amount);
	}

	public boolean has(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		return this.hasHelper(player.getName(), amount);
	}

	/*
	 * Withdraw money from the player
	 */
	public EconomyResponse withdrawPlayer(String playerName, double amount) {
		Bukkit.getConsoleSender().sendMessage("withdrawPlayer 1 called.");
		return economy.withdrawPlayer(playerName, amount);
	}

	public EconomyResponse withdrawPlayer(OfflinePlayer player, double amount) {
		Bukkit.getConsoleSender().sendMessage("withdrawPlayer 2  OFFLINE called.");
		return economy.withdrawPlayer(player.getName(), amount);
	}

	public EconomyResponse withdrawPlayer(String playerName, String worldName, double amount) {
		Bukkit.getConsoleSender().sendMessage("withdrawPlayer 3 called.");
		return economy.withdrawPlayer(playerName, amount);
	}

	public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("withdrawPlayer 4 called.");
		return economy.withdrawPlayer(player.getName(), amount);
	}

	public EconomyResponse depositPlayer(String playerName, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("depositPlayer 1 called.");
		return economy.depositPlayer(playerName, amount);
	}

	public EconomyResponse depositPlayer(OfflinePlayer player, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("depositPlayer 2 called.");
		return economy.depositPlayer(player.getName(), amount);
	}

	public EconomyResponse depositPlayer(String playerName, String worldName, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("depositPlayer 3 called.");
		return economy.depositPlayer(playerName, amount);
	}

	public EconomyResponse depositPlayer(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("depositPlayer 4 called.");
		return economy.depositPlayer(player.getName(), amount);
	}

	public EconomyResponse createBank(String name, String player) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createBank 1 called.");
		return null;
	}

	public EconomyResponse createBank(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createBank 2 called.");
		return null;
	}

	public EconomyResponse deleteBank(String name) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("deleteBank called.");
		return null;
	}

	public EconomyResponse bankBalance(String name) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("bankBalance called.");
		return null;
	}

	public EconomyResponse bankHas(String name, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("bankHas called.");
		return null;
	}

	public EconomyResponse bankWithdraw(String name, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("bankWithdraw called.");
		return null;
	}

	public EconomyResponse bankDeposit(String name, double amount) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("bankDeposit called.");
		return null;
	}

	public EconomyResponse isBankOwner(String name, String playerName) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("isBankOwner 1 called.");
		return null;
	}

	public EconomyResponse isBankOwner(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("isBankOwner 2 called.");
		return null;
	}

	public EconomyResponse isBankMember(String name, String playerName) {
		Bukkit.getConsoleSender().sendMessage("isBankMember 1 called.");
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse isBankMember(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("isBankMember 2 called.");
		return null;
	}

	public List<String> getBanks() {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("getBanks called.");
		return null;
	}

	public boolean createPlayerAccount(String playerName) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createPlayerAccount 1 called.");
		return false;
	}

	public boolean createPlayerAccount(OfflinePlayer player) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createPlayerAccount 2 called.");
		return false;
	}

	public boolean createPlayerAccount(String playerName, String worldName) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createPlayerAccount 3 called.");
		return false;
	}

	public boolean createPlayerAccount(OfflinePlayer player, String worldName) {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("createPlayerAccount 4 called.");
		return false;
	}
	
}