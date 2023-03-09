package me.kevind;

import me.kevind.commands.PromptReloadCommand;
import me.kevind.listeners.InventoryClickListener;
import me.kevind.listeners.JoinListener;
import me.kevind.menu.InfoMenu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class IntegralPrompt extends JavaPlugin {
    private static InfoMenu infomenu;
    public static InfoMenu getInfomenu() {
        return infomenu;
    }
    private static IntegralPrompt instance;
    public static IntegralPrompt getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        infomenu = new InfoMenu();

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        //register commands
        getCommand("promptreload").setExecutor(new PromptReloadCommand());
        //register listeners
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        saveConfig();
    }
}
