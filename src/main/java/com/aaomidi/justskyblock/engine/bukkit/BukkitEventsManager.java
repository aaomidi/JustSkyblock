package com.aaomidi.justskyblock.engine.bukkit;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.engine.bukkit.events.BukkitPlayerConnectEvent;
import org.bukkit.event.Listener;

/**
 * @author aaomidi
 */
public class BukkitEventsManager {
    private final JustSkyblock instance;

    public BukkitEventsManager(JustSkyblock instance) {
        this.instance = instance;
        this.registerEvents();
    }

    /**
     * Add all events needing to be registered here.
     */
    private void registerEvents() {
        registerEvent(new BukkitPlayerConnectEvent(instance));
    }

    private void registerEvent(Listener listener) {
        instance.getServer().getPluginManager().registerEvents(listener, instance);
    }
}
