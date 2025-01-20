package me.aciner.testPlugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import me.aciner.testPlugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

@CommandAlias("reply|r")
public class ReplyCommand extends BaseCommand {

    private TestPlugin plugin;

    public ReplyCommand(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    @CommandCompletion("@nothing")
    @Description("Reply to the last person to message you.")
    public void onCommand(Player player, String[] args) {

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Invalid Syntax!");
            return;
        }

        StringBuilder message = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }

        if (plugin.getRecentMessages().get(player.getUniqueId()) == null) {
            player.sendMessage(ChatColor.RED + "You have no one to reply to!");
            return;
        }

        UUID targetUUID = plugin.getRecentMessages().get(player.getUniqueId());
        Player target = (Player) Bukkit.getPlayer(targetUUID);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "You have no one to reply to!");
            return;
        }

        target.sendMessage(player.getName() + ChatColor.AQUA + " -> " + ChatColor.WHITE + "you: " + message);
        player.sendMessage("You" + ChatColor.AQUA + " -> " + ChatColor.WHITE + target.getName() + ": " + message);

    }
}
