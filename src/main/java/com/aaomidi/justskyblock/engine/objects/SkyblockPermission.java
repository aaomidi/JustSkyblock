package com.aaomidi.justskyblock.engine.objects;

import com.aaomidi.justskyblock.engine.objects.enums.PermissionLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public class SkyblockPermission {
    @Getter
    private final int islandID;
    @Getter
    @Setter
    @NonNull
    private PermissionLevel permissionLevel;
}
