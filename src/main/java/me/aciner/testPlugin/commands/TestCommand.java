package me.aciner.testPlugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;

public class TestCommand extends BaseCommand {

    @Default
    @CommandAlias("test")
    @Description("Test command.")
    public void onCommand(Player player) {

        player.sendTitle("Hello", "You are a great person!!!");
        player.sendActionBar(ChatColor.RED + "GANGSTER");
        player.setPlayerListName("gangster " + player.getName());
        player.setPlayerListHeader("FORTNITe\n");
        player.setPlayerListFooter("\nTOO GANG FOR ME");

        BossBar bossBar = Bukkit.createBossBar(/* title 1st arg */ ChatColor.DARK_PURPLE + "hi", BarColor.BLUE, BarStyle.SEGMENTED_6);
        bossBar.addPlayer(player);
        player.launchProjectile(Egg.class, player.getLocation().getDirection());

    }
}
