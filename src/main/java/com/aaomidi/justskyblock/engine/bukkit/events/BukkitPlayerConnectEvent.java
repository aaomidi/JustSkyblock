package com.aaomidi.justskyblock.engine.bukkit.events;

import com.aaomidi.justskyblock.JustSkyblock;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class BukkitPlayerConnectEvent implements Listener {
    private final JustSkyblock instance;

    @EventHandler(priority = EventPriority.MONITOR)
    public void constructSkyblockPlayerObject(PlayerLoginEvent event) {
        //TODO: Nothing until we finish database stuffs!
    }
}
