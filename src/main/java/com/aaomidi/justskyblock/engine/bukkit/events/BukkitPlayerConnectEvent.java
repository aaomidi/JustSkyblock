package com.aaomidi.justskyblock.engine.bukkit.events;

import com.aaomidi.justskyblock.JustSkyblock;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class BukkitPlayerConnectEvent {
    private JustSkyblock instance;

    @EventHandler(priority = EventPriority.MONITOR)
    public void constructSkyblockPlayerObject(PlayerLoginEvent event) {
        //TODO: Nothing until we finish database stuffs!
    }
}
