package com.aaomidi.justskyblock.engine.objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.util.Vector;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class SkyblockIsland {
    @Getter
    private final int islandID;
    @Getter
    private final String serverName;
    @Getter
    private final Vector min;
    @Getter
    private final Vector max;
    @Getter
    private final boolean isPurged;

}
