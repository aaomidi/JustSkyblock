package com.aaomidi.justskyblock.storage;

import com.aaomidi.justskyblock.engine.objects.SkyblockIsland;
import com.aaomidi.justskyblock.engine.objects.SkyblockPlayer;

/**
 * @author aaomidi
 */
public abstract class DataStorageInterface {

    public abstract SkyblockPlayer getSkyblockPlayer(String playerName);

    public abstract SkyblockIsland getSkyblockIsland();
}
