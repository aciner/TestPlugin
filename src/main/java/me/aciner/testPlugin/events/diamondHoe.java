package me.aciner.testPlugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class diamondHoe implements Listener {

    private static HashMap<UUID, Integer> Ammo = new HashMap<>();

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {

        if (e.hasItem()) {
            if (!e.getItem().getType().equals(Material.DIAMOND_HOE)) {
                return;
            }
            if (!e.getAction().equals(Action.RIGHT_CLICK_AIR) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
                return;
            }

            Player player = e.getPlayer();
            if (Ammo.get(player.getUniqueId()) == null) {
                Ammo.put(player.getUniqueId(), 19);
            } else {
                if (Ammo.get(player.getUniqueId()) == 0) {
                    Ammo.put(player.getUniqueId(), 20);
                    player.sendActionBar(ChatColor.AQUA + "Reloading...");
                    player.playSound(player.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
                    return;
                }
                Ammo.put(player.getUniqueId(), Ammo.get(player.getUniqueId()) -1);
            }

            player.launchProjectile(Snowball.class, player.getLocation().getDirection());
            player.playSound(player.getLocation() ,Sound.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON, 1, 1);
            player.sendActionBar(ChatColor.WHITE + String.valueOf(Ammo.get(player.getUniqueId())) + "/20 " + ChatColor.AQUA + "Ammo.");

        }
    }
}
