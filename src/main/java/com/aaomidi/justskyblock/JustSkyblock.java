package com.aaomidi.justskyblock;

import com.aaomidi.justskyblock.engine.EngineManager;
import com.aaomidi.justskyblock.utils.StringManager;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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
    }

    @Override
    public void onEnable() {
        this.setupWorldEdit();
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

}