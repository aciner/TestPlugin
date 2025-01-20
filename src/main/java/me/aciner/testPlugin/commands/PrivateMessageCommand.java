package me.aciner.testPlugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.aciner.testPlugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("pm|dm|message|msg|whisper|w")
public class PrivateMessageCommand extends BaseCommand {

    private TestPlugin plugin;

    public PrivateMessageCommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    @Description("Messages a player")
    @CommandCompletion("@players @nothing")
    public void onCommand(Player player, String[] args) {

        if (args.length < 2) {
            player.sendMessage(ChatColor.RED + "Invalid Syntax!");
            return;
        }

        Player target = (Player) Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Invalid Player!");
            return;
        }

        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }

        target.sendMessage(player.getName() + ChatColor.AQUA + " -> " + ChatColor.WHITE + "you: " + message);
        player.sendMessage("You" + ChatColor.AQUA + " -> " + ChatColor.WHITE + target.getName() + ": " + message);

        plugin.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());

    }
}
