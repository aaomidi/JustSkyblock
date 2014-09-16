package com.aaomidi.justskyblock.engine.generator;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.regions.Region;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;


/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class IslandGeneration {
    private final JustSkyblock instance;
    private final BaseBlock AIR = new BaseBlock(Material.AIR.getId());

    private void buildIsland(Vector loc1, Vector loc2, World world) {
        try {
            EditSession editSession = instance.getEngineManager().getWorldEditUtils().getEditSession(world);
            editSession.enableQueue();
            Region region = LocationsParser.getRegion(loc1, loc2);
            // Replacing the blocks is MUCH faster than just setting them all to air.
            editSession.replaceBlocks(region, null, AIR);
            // Loading schematics.
            // Cause pokemon is awesome.
        } catch (Exception ex) {
            throw new RuntimeException("Problem with generating island.", ex);
        }

    }


}
