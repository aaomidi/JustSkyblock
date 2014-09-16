package com.aaomidi.justskyblock.api;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.api.command.SkyblockCommandAPI;
import lombok.Getter;

import java.util.WeakHashMap;

/**
 * @author aaomidi
 */
public class API {
    private final JustSkyblock instance;
    @Getter
    private SkyblockCommandAPI skyblockCommandAPI;

    public API(JustSkyblock instance) {
        this.instance = instance;
        this.init();
    }

    private void init() {
        skyblockCommandAPI = new SkyblockCommandAPI(instance);
        WeakHashMap<String, String> map = new WeakHashMap<>();
    }


}
