package com.aaomidi.justskyblock.engine.objects;

import lombok.RequiredArgsConstructor;
import org.bukkit.util.Vector;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class SkyblockIsland {
    private final int islandID;
    private final Vector min;
    private final Vector max;
    private final boolean isPurged;
}
