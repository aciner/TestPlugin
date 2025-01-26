package me.aciner.testPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class ServerPingEvent implements Listener {

    private static boolean ServerPinged = false;

    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMaxPlayers(100);
        e.setMotd(ChatColor.RED + "TEST SERVER " + ChatColor.BLUE + "[1.21]\n" + ChatColor.GREEN + "Join up for epic test server" );
        try {
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
        } catch (Exception ex) {
            if (ServerPinged != true) {
                ex.printStackTrace();
                ServerPinged = true;
            }
        }

    }
}
