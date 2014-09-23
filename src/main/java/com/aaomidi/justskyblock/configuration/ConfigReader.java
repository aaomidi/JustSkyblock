package com.aaomidi.justskyblock.configuration;

import com.aaomidi.justskyblock.JustSkyblock;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author aaomidi
 */

public class ConfigReader {
    private static FileConfiguration config;
    private final JustSkyblock instance;

    public ConfigReader(JustSkyblock instance) {
        this.instance = instance;
        config = instance.getConfig();
    }

    public static String getPrefix() {
        return config.getString("General-Settings.Prefix");
    }
}
