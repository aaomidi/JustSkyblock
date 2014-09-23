package com.aaomidi.justskyblock.storage;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.engine.objects.SkyblockPlayer;

import java.util.concurrent.ConcurrentMap;

/**
 * @author aaomidi
 */
public class StorageManagement {
    private static ConcurrentMap<String, SkyblockPlayer> skyblockPlayers;
    private static DataStorageInterface data;
    private final JustSkyblock instance;

    public StorageManagement(JustSkyblock instance) {
        this.instance = instance;
        //TODO: Get the data storage type.
        data = null;
    }
}
