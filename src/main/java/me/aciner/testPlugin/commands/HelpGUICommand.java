package me.aciner.testPlugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import me.aciner.testPlugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

@CommandAlias("help")
public class HelpGUICommand extends BaseCommand {

    private TestPlugin plugin;

    public HelpGUICommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    @Description("A basic help command")
    @CommandCompletion("@nothing")
    public void onCommand(Player player) {

        Inventory GUI = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Help");

        GUI.setItem(0, new ItemStack(Material.BARRIER));
        player.playSound(player, Sound.BLOCK_BARREL_OPEN, 1, 1);

        player.openInventory(GUI);

    }
}
