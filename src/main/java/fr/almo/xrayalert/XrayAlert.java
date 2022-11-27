package fr.almo.xrayalert;

import fr.almo.xrayalert.commands.TeleportCommand;
import fr.almo.xrayalert.listeners.MiningListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class XrayAlert extends JavaPlugin {

    @Override
    public void onEnable() {

        //listeners
        Bukkit.getServer().getPluginManager().registerEvents(new MiningListener(), this);

        //commands
        getCommand("xateleport").setExecutor(new TeleportCommand());

    }

}
