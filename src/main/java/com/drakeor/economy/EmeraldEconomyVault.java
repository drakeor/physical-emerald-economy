package com.drakeor.economy;

import java.util.List;

import org.bukkit.OfflinePlayer;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

class EmeraldEconomyVault implements Economy
{

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasBankSupport() {
		// TODO Auto-generated method stub
		return false;
	}

	public int fractionalDigits() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String format(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public String currencyNamePlural() {
		// TODO Auto-generated method stub
		return null;
	}

	public String currencyNameSingular() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasAccount(String playerName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasAccount(OfflinePlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasAccount(String playerName, String worldName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasAccount(OfflinePlayer player, String worldName) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getBalance(String playerName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getBalance(OfflinePlayer player) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getBalance(String playerName, String world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getBalance(OfflinePlayer player, String world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean has(String playerName, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean has(OfflinePlayer player, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean has(String playerName, String worldName, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean has(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public EconomyResponse withdrawPlayer(String playerName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse withdrawPlayer(OfflinePlayer player, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse withdrawPlayer(String playerName, String worldName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse depositPlayer(String playerName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse depositPlayer(OfflinePlayer player, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse depositPlayer(String playerName, String worldName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse depositPlayer(OfflinePlayer player, String worldName, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse createBank(String name, String player) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse createBank(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse deleteBank(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse bankBalance(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse bankHas(String name, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse bankWithdraw(String name, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse bankDeposit(String name, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse isBankOwner(String name, String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse isBankOwner(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse isBankMember(String name, String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EconomyResponse isBankMember(String name, OfflinePlayer player) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getBanks() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createPlayerAccount(String playerName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createPlayerAccount(OfflinePlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createPlayerAccount(String playerName, String worldName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createPlayerAccount(OfflinePlayer player, String worldName) {
		// TODO Auto-generated method stub
		return false;
	}
	
}