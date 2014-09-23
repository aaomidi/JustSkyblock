package com.aaomidi.justskyblock.engine.generation;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.regions.Region;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Iterator;


/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class IslandGeneration {
    private final JustSkyblock instance;
    private final BaseBlock AIR = new BaseBlock(Material.AIR.getId());
    // TODO: Re-Write so it doesn't try to spawn everything at the same time.

    /**
     * Clean up all blocks in a location and paste the island schematic instead.
     *
     * @param loc1  Minimum point of the island.
     * @param loc2  Maximum point of the island.
     * @param world World to create the island in.
     * @param file  Schematic file to load.
     */
    protected Region buildIsland(Vector loc1, Vector loc2, World world, File file) {
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
            return region;
        } catch (Exception ex) {
            throw new RuntimeException("Problem with generating island.", ex);
        }
    }

    protected void editIsland(Region region) {
        Iterator<BlockVector> iterator = region.iterator();
        while (iterator.hasNext()) {
            BlockVector bv = iterator.next();
            World world = instance.getServer().getWorld(region.getWorld().getName());
            Block block = world.getBlockAt(bv.getBlockX(), bv.getBlockY(), bv.getBlockZ());
            if (block.getType().equals(Material.CHEST)) {
                //TODO: Add items to chest.
            } else if (block.getType().equals(Material.WALL_SIGN) || block.getType().equals(Material.SIGN_POST) || block.getType().equals(Material.SIGN)) {
                //TODO: Edit the sign with a welcome message.
            }
        }
    }


}
