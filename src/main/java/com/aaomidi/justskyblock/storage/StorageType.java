package com.aaomidi.justskyblock.storage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aaomidi
 */
@RequiredArgsConstructor
public enum StorageType {
    MySQL("MySQL"),
    MongoDB("MongoDB"),
    FlatFile("FlatFile");
    @Getter
    private final String storageType;

    public String toString() {
        return storageType;
    }
}
