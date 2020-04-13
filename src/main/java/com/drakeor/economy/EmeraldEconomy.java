package com.drakeor.economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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
		
		Bukkit.getLogger().warning("[PhysicalEmeraldEconomy] Plugin loaded.");
    }

    @Override
    public void onDisable() {
    	if (Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
    	    vaultHook.unhook();
    	}
    	Bukkit.getLogger().warning("[PhysicalEmeraldEconomy] Plugin unloaded.");
    }
}