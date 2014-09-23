package com.aaomidi.justskyblock.engine.generation;

import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.schematic.SchematicFormat;
import org.bukkit.World;

import java.io.File;

/**
 * @author aaomidi
 */
public class WorldEditUtils {
    private final JustSkyblock instance;

    public WorldEditUtils(JustSkyblock instance) {
        this.instance = instance;
    }

    protected EditSession getEditSession(World world) {
        return instance.getWorldEditPlugin().getWorldEdit().getEditSessionFactory().getEditSession(LocationsParser.getWorldEditWorld(world), -1);
    }

    protected SchematicFormat getSchematicFormat(File file) {
        return SchematicFormat.getFormat(file);
    }

    protected CuboidClipboard getCuboidClipboard(File file) throws Exception {
        return getSchematicFormat(file).load(file);
    }


}
