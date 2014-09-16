package com.aaomidi.justskyblock.engine.generator;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.regions.Region;
import lombok.RequiredArgsConstructor;
import org.bukkit.World;
import org.bukkit.util.Vector;


/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class IslandGeneration {
    private final JustSkyblock instance;

    private void generateIsland(Vector loc1, Vector loc2, World world) {
        EditSession editSession = getEditSession(world);
        editSession.enableQueue();
        Region region = LocationsParser.getRegion(loc1, loc2);
    }

    private EditSession getEditSession(World world) {
        return instance.getWorldEditPlugin().getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(world), -1);
    }
}
