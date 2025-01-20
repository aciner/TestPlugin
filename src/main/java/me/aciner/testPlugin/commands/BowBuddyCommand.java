package me.aciner.testPlugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BowBuddyCommand extends BaseCommand {

    @Default
    @CommandAlias("bowbuddy")
    @Description("Gives you the bow buddy item")
    public void onCommand(Player player) {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.setDisplayName(ChatColor.DARK_PURPLE + "Bow Buddy");
        bow.setItemMeta(bowmeta);

        player.getInventory().addItem(bow);
    }
}
