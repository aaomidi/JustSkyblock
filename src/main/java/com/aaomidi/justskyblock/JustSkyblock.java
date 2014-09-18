package com.aaomidi.justskyblock;

import com.aaomidi.justskyblock.engine.EngineManager;
import com.aaomidi.justskyblock.utils.StringManager;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author aaomidi
 */
public class JustSkyblock extends JavaPlugin {
    @Getter
    private WorldEditPlugin worldEditPlugin;
    @Getter
    private EngineManager engineManager;

    @Override
    public void onLoad() {
        this.generateFiles();
    }


    @Override
    public void onEnable() {
        this.setupWorldEdit();
        this.setupClasses();
    }

    @Override
    public void onDisable() {
    }

    private void setupWorldEdit() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldEdit");
        if (plugin == null) {
            this.getLogger().severe(StringManager.colorize("&cWorldEdit plugin not found."));
            this.getServer().getPluginManager().disablePlugin(this);
        }
        worldEditPlugin = (WorldEditPlugin) plugin;
    }

    private void setupClasses() {
        engineManager = new EngineManager(this);
    }

    private void generateFiles() {
        File configFile = new File(this.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            this.saveDefaultConfig();
        }
    }
}