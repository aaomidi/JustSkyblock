package com.aaomidi.justskyblock.engine.objects;

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
    private HashSet<SkyblockPermission> skyblockPermissions;

    /**
     * Gets bukkit's player object.
     *
     * @return Bukkit's player object.
     */
    public Player getBase() {
        if (base == null) {
            Player player = Bukkit.getPlayer(playerName);
            base = player;
        }
        return base;
    }
}
