package com.aaomidi.justskyblock.engine;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.engine.generation.IslandGeneration;
import com.aaomidi.justskyblock.engine.generation.LocationsParser;
import com.aaomidi.justskyblock.engine.generation.WorldEditUtils;
import lombok.Getter;

/**
 * @author aaomidi
 */
public class EngineManager {
    private final JustSkyblock instance;
    @Getter
    protected IslandGeneration islandGeneration;
    @Getter
    protected LocationsParser locationsParser;
    @Getter
    protected WorldEditUtils worldEditUtils;

    public EngineManager(JustSkyblock instance) {
        this.instance = instance;
    }

    private void init() {
        locationsParser = new LocationsParser(instance);
        worldEditUtils = new WorldEditUtils(instance);
        islandGeneration = new IslandGeneration(instance);
    }

}
