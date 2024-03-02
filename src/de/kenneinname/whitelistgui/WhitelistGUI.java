package de.kenneinname.whitelistgui;

import de.kenneinname.whitelistgui.commands.WhitelistGUICommand;
import de.kenneinname.whitelistgui.commands.WhitelistGUIPlayerCommand;
import de.kenneinname.whitelistgui.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WhitelistGUI extends JavaPlugin {

    public static final String PREFIX = "§7[§6Whitelist§7-§6GUI§7] ";
    private static WhitelistGUI whitelistGUI;

    @Override
    public void onEnable() {
        whitelistGUI = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin aktiviert!");

        registerCommand();
        registerListener();
    }

    private void registerCommand() {
        this.getCommand("whitelistgui").setExecutor(new WhitelistGUICommand());
        this.getCommand("whitelistguiplayers").setExecutor(new WhitelistGUIPlayerCommand());
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static WhitelistGUI getPlugin() {
        return whitelistGUI;
    }
}
