package com.aaomidi.justskyblock.storage.mysql;

import com.aaomidi.justskyblock.JustSkyblock;

/**
 * @author aaomidi
 */
public class MySQLManager {
    private final JustSkyblock instance;
    private final MySQLConnector mySQLConnector;

    public MySQLManager(JustSkyblock instance) {
        this.instance = instance;
        //TODO: Actually make this point to something :P
        this.mySQLConnector = null;
    }

    public void initTables() {
        //TODO: Mark you write these, you know how to make more efficient queries. :P
        String query = "";
    }
}
