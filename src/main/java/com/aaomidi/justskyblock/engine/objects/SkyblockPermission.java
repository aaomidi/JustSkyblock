package com.aaomidi.justskyblock.engine.objects;

import com.aaomidi.justskyblock.engine.objects.enums.PermissionLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class SkyblockPermission {
    /*@Getter
    private static String serverName;
    Instead of this we can just not load islands who are not on this server.
    */
    @Getter
    private final Vector max;
    @Getter
    private final Vector min;
    @Getter
    @Setter
    @NonNull
    private PermissionLevel permissionLevel;

    /**
     * Given a location, see if its in this island.
     *
     * @param loc Location of an object.
     */
    public boolean isInIsland(Location loc) {
        return loc.toVector().isInAABB(max, min);
    }
}
