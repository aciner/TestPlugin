package me.aciner.testPlugin.events;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class bowBuddy implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        ItemMeta meta = e.getBow().getItemMeta();

        if (!meta.getDisplayName().equals(ChatColor.DARK_PURPLE + "Bow Buddy")) {
            return;
        }

        Player player = (Player) e.getEntity();
        e.getProjectile().addPassenger(player);

    }

    @EventHandler
    public void onProjectileLand(ProjectileHitEvent e) {
        if (!(e.getEntity().getPassenger() instanceof Player)) {
            return;
        }

        Player player = (Player) e.getEntity().getPassenger();

        Location location = new Location(player.getWorld(),
                player.getLocation().getX(),
                player.getLocation().getY() + 1,
                player.getLocation().getZ(),
                player.getLocation().getYaw(),
                player.getLocation().getPitch());

        player.teleport(location);

    }
}
