package com.aaomidi.justskyblock.storage;

import com.aaomidi.justskyblock.engine.objects.SkyblockIsland;
import com.aaomidi.justskyblock.engine.objects.SkyblockPlayer;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @author aaomidi
 */
//TODO: Finish the damned javadocs :P
public abstract class DataStorageInterface {
    /**
     * Gets the skyblock player.
     *
     * @param playerName Name of player.
     * @return SkyblockPlayer object.
     */
    public abstract SkyblockPlayer getSkyblockPlayer(String playerName);

    /**
     * Gets the skyblock island.
     *
     * @param uuid Unique ID of player.
     * @return SkyblockPlayer object.
     */
    public abstract SkyblockPlayer getSkyblockPlayer(UUID uuid);

    /**
     * Gets the skyblock island.
     *
     * @param playerName Name of player.
     * @return SkyblockIsland object.
     */
    public abstract SkyblockIsland getSkyblockIsland(String playerName);

    /**
     * Gets the skyblock island.
     *
     * @param uuid Unique ID of player.
     * @return SkyblockIsland object.
     */
    public abstract SkyblockIsland getSkyblockIsland(UUID uuid);

    /**
     * Gets the last skyblock island that was purged.
     *
     * @return Last skyblock island that was purged. If none exists the method will return null.
     */
    public abstract SkyblockIsland getLastPurgedIsland();

    public abstract boolean createSkyblockPlayer(String playerName);

    public abstract boolean createSkyblockPlayer(UUID uuid);

    public abstract boolean createSkyblockIsland(String playerName, String serverName, Vector min, Vector max);

    public abstract boolean createSkyblockIsland(UUID uuid, String serverName, Vector min, Vector max);

    public abstract boolean updateSkyblockPlayer(SkyblockPlayer skyblockPlayer);

    public abstract boolean updateSkyblockIsland(SkyblockIsland skyblockIsland);

}
