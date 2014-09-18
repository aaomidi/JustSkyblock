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
        this.initTables();
    }

    private void initTables() {
        /*
        Create the sb_index table:
        playerID INT A_I
        uuid CHAR(32) UNIQUE
        playerName VARCHAR(16)
         */
        String playerIndexQuery = "CREATE TABLE IF NOT EXISTS `sb_index`(`playerID` INT NOT NULL AUTO_INCREMENT, `uuid` CHAR(36) UNIQUE NOT NULL, `playerName` VARCHAR(16) NOT NULL, PRIMARY KEY(`playerID`))Engine=InnoDB DEFAULT CHARSET=utf8;";
        mySQLConnector.executeQuery(playerIndexQuery);
    }
}
