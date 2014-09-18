package com.aaomidi.justskyblock.engine.objects.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public enum PermissionLevel {
    NONE(0),
    ENTERING(1),
    BUILDING(2),
    OWNERSHIP(3);
    private final int permissionInt;

    /**
     * Get the PermissionLevel value from an integer.
     *
     * @param i permissionInt.
     * @return PermissionLevel.
     */
    public PermissionLevel valueOf(int i) {
        switch (i) {
            case 1:
                return PermissionLevel.ENTERING;
            case 2:
                return PermissionLevel.BUILDING;
            case 3:
                return PermissionLevel.OWNERSHIP;
            default:
                return PermissionLevel.NONE;
        }
    }
}
