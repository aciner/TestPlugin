package me.aciner.testPlugin.events;

import me.aciner.testPlugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HelpGUIListener implements Listener {

    private TestPlugin plugin;

    public HelpGUIListener(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals(ChatColor.DARK_PURPLE + "Help")) {

            e.setCancelled(true);

            switch (e.getRawSlot()) {
                case 0:
                    player.closeInventory();
                    player.playSound(player, Sound.BLOCK_BARREL_CLOSE, 1, 1);

                case 20:
                    player.getInventory().getItemInMainHand();
                    if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                        NamespacedKey key = new NamespacedKey(plugin, "generic.attack_damage");
                        AttributeModifier modifier = new AttributeModifier(key, 100, AttributeModifier.Operation.ADD_NUMBER);
                        ItemStack item = player.getInventory().getItemInMainHand();
                        ItemMeta meta = item.getItemMeta();
                        try {
                            if (!meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).contains(modifier)){
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            }
                        } catch (NullPointerException ex) {
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                        }

                        item.setItemMeta(meta);

                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                    } else {
                        return;
                    }

                default:
                    return;
            }

        }

    }
}
