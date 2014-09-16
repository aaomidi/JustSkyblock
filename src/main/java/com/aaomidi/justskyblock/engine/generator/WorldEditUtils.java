package com.aaomidi.justskyblock.engine.generator;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.EditSession;
import org.bukkit.World;

/**
 * @author aaomidi
 */
public class WorldEditUtils {
    private final JustSkyblock instance;

    public WorldEditUtils(JustSkyblock instance) {
        this.instance = instance;
    }

    private EditSession getEditSession(World world) {
        return instance.getWorldEditPlugin().getWorldEdit().getEditSessionFactory().getEditSession(LocationsParser.getWorldEditWorld(world), -1);
    }

}
