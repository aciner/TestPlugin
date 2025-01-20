package me.aciner.testPlugin;

import co.aikar.commands.PaperCommandManager;
import me.aciner.testPlugin.commands.BowBuddyCommand;
import me.aciner.testPlugin.commands.PrivateMessageCommand;
import me.aciner.testPlugin.commands.ReplyCommand;
import me.aciner.testPlugin.commands.TestCommand;
import me.aciner.testPlugin.events.ServerPingEvent;
import me.aciner.testPlugin.events.bowBuddy;
import me.aciner.testPlugin.events.diamondHoe;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class TestPlugin extends JavaPlugin {

    private HashMap<UUID, UUID> recentMessanger;

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new diamondHoe(), this);
        Bukkit.getPluginManager().registerEvents(new bowBuddy(), this);
        Bukkit.getPluginManager().registerEvents(new ServerPingEvent(), this);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new TestCommand());
        manager.registerCommand(new BowBuddyCommand());
        manager.registerCommand(new PrivateMessageCommand(this));
        manager.registerCommand(new ReplyCommand(this));

        recentMessanger = new HashMap<>();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<UUID, UUID> getRecentMessages() {return recentMessanger; }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        recentMessanger.remove(e.getPlayer().getUniqueId());
    }
}
