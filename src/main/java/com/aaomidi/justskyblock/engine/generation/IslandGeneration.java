package com.aaomidi.justskyblock.engine.generation;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.regions.Region;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.io.File;


/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class IslandGeneration {
    private final JustSkyblock instance;
    private final BaseBlock AIR = new BaseBlock(Material.AIR.getId());

    // TODO: Re-Write so it doesn't try to spawn everything at the same time.
    private void buildIsland(Vector loc1, Vector loc2, World world, File file) {
        try {
            EditSession editSession = instance.getEngineManager().getWorldEditUtils().getEditSession(world);
            editSession.enableQueue();
            Region region = LocationsParser.getRegion(loc1, loc2);
            // Replacing the blocks is MUCH faster than just setting them all to air.
            editSession.replaceBlocks(region, null, AIR);
            editSession.flushQueue();
            // Loading schematics.
            CuboidClipboard cuboidClipboard = instance.getEngineManager().getWorldEditUtils().getCuboidClipboard(file);
            // Pasting the schematic.
            cuboidClipboard.paste(editSession, region.getCenter(), false);
            editSession.flushQueue();
            // Cause pokemon is awesome.
        } catch (Exception ex) {
            throw new RuntimeException("Problem with generating island.", ex);
        }

    }
    //TODO: Edit the generated island and add stuff to the chest.
    //TODO: Edit the generated island and edit the sign and add the player's name on there.


}
