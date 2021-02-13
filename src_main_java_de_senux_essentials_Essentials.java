package de.senux.essentials;

import de.senux.essentials.command.GamemodeCommand;
import de.senux.essentials.command.HealCommand;
import de.senux.essentials.command.KillCommand;
import de.senux.essentials.listener.ConnectionListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Essentials extends JavaPlugin {

    @Getter
    private static Essentials instance;
    private final String prefix = "§8[§cEssentials§8] §7";


    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new ConnectionListener(), this);
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("kill").setExecutor(new KillCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
    }

    @Override
    public void onDisable() {

    }


}
