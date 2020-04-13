package com.drakeor.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.ServicePriority;

import net.milkbowl.vault.economy.Economy;

public class VaultHook {

    private EmeraldEconomy plugin = EmeraldEconomy.economyInstance;

    private Economy provider;

    /**
     * Hooks Physical Emerald Economy into vault.
     */
    public void hook() {
	provider = plugin.emeraldEconomyVault;
	Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
	Bukkit.getConsoleSender()
		.sendMessage(ChatColor.GREEN + "VaultAPI hooked into " + ChatColor.AQUA + plugin.getName());
    }

    /**
     * Unhooks Physical Emerald Economy from vault.
     */
    public void unhook() {
	Bukkit.getServicesManager().unregister(Economy.class, this.provider);
	Bukkit.getConsoleSender()
		.sendMessage(ChatColor.YELLOW + "VaultAPI unhooked from " + ChatColor.AQUA + plugin.getName());

    }
}
