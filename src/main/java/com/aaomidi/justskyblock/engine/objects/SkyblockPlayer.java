package com.aaomidi.justskyblock.engine.objects;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author aaomidi
 */
//TODO: Basically add more information.
@RequiredArgsConstructor
public class SkyblockPlayer {
    private final int playerID;
    private final String playerName;
    private final UUID uuid;
    private Player base;

    public Player getBase() {
        if (base == null) {
            Player player = Bukkit.getPlayer(playerName);
            base = player;
        }
        return base;
    }
}
