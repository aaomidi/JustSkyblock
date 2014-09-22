package com.aaomidi.justskyblock.engine.protection.events;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.engine.objects.SkyblockPermission;
import com.aaomidi.justskyblock.engine.objects.SkyblockPlayer;
import com.aaomidi.justskyblock.engine.objects.enums.PermissionLevel;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author aaomidi
 */
public class SkyblockIslandProtectedEvent implements Listener {
    private final JustSkyblock instance;

    public SkyblockIslandProtectedEvent(JustSkyblock instance) {
        this.instance = instance;
    }

    public void onIslandEnter(PlayerMoveEvent event) {
        if (event.getFrom().toVector().distanceSquared(event.getTo().toVector()) < 1) {
            return;
        }
        Player player = event.getPlayer();
        //TODO: Make this point somewhere
        SkyblockPlayer skyblockPlayer = null;
        for (SkyblockPermission perm : skyblockPlayer.getSkyblockPermissions()) {
            if (!perm.isInIsland(player.getLocation())) {
                continue;
            }
            if (!perm.getPermissionLevel().equals(PermissionLevel.BUILDING) || !perm.getPermissionLevel().equals(PermissionLevel.ENTERING) || !perm.getPermissionLevel().equals(PermissionLevel.OWNERSHIP)) {
                //TODO: Send message to player that they're not allowed to enter the island.
                event.setCancelled(true);
            }
        }

    }
}
