package me.aciner.testPlugin;

import co.aikar.commands.PaperCommandManager;
import me.aciner.testPlugin.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
