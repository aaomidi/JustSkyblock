package com.aaomidi.justskyblock.engine.objects;

import com.aaomidi.justskyblock.engine.objects.enums.PermissionLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

/**
 * @author aaomidi
 */
//TODO: Basically add more information.
@RequiredArgsConstructor
public class SkyblockPlayer {
    @Getter
    private final int playerID;
    @Getter
    private final String playerName;
    @Getter
    private final UUID uuid;
    private Player base;
    @NonNull
    @Getter
    private HashSet<SkyblockPermission> skyblockPermissions = new HashSet<SkyblockPermission>();

    /**
     * Gets bukkit's player object.
     *
     * @return Bukkit's player object.
     */
    public Player getBase() {
        if (base == null) {
            base = Bukkit.getPlayer(playerName);
        }
        return base;
    }

    /**
     * Returns the player's Skyblock island where he is the owner of them.
     *
     * @return The player's island.
     */
    public SkyblockIsland getSkyblockIsland() {
        for (SkyblockPermission permission : skyblockPermissions) {
            if (!permission.getPermissionLevel().equals(PermissionLevel.OWNERSHIP)) {
                continue;
            }
            //TODO: Make this return something.
            return null;
        }
        return null;
    }
}
