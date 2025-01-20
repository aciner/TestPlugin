package me.aciner.testPlugin;

import co.aikar.commands.PaperCommandManager;
import me.aciner.testPlugin.commands.BowBuddyCommand;
import me.aciner.testPlugin.commands.TestCommand;
import me.aciner.testPlugin.events.ServerPingEvent;
import me.aciner.testPlugin.events.bowBuddy;
import me.aciner.testPlugin.events.diamondHoe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new diamondHoe(), this);
        Bukkit.getPluginManager().registerEvents(new bowBuddy(), this);
        Bukkit.getPluginManager().registerEvents(new ServerPingEvent(), this);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new TestCommand());
        manager.registerCommand(new BowBuddyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
