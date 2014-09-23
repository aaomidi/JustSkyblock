package com.aaomidi.justskyblock.storage.mysql;

import com.aaomidi.justskyblock.JustSkyblock;
import org.bukkit.entity.Player;

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
        sb_index:
        id INT AUTO_INCREMENT,
        uuid CHAR(32) UNIQUE,
        playerName VARCHAR(16),
        PRIMARY KEY(id),
        INDEX (uuid);
         */
        String playerIndexQuery = "CREATE TABLE IF NOT EXISTS `sb_index`(`id` INT AUTO_INCREMENT, `uuid` CHAR(36) UNIQUE NOT NULL, `playerName` VARCHAR(16) NOT NULL, PRIMARY KEY(`id`), INDEX(`uuid`))Engine=InnoDB DEFAULT CHARSET=utf8;";
        /*
        sb_islands:
        id INT AUTO_INCREMENT
        x INT NOT NULL,
        z INT NOT NULL,
        isPurged BOOLEAN,
        PRIMARY KEY (id);
         */
        String islandsIndexQuery = "CREATE TABLE IF NOT EXISTS `sb_islands`(`id` INT AUTO_INCREMENT, `x` INT NOT NULL, `z` INT NOT NULL, `isPurged` BOOLEAN NOT NULL DEFAULT FALSE, PRIMARY KEY(`id`))Engine=InnoDB DEFAULT CHARSET=utf8;";
        /*
        sb_permissions:
        playerID INT NOT NULL,
        islandID INT NOT NULL,
        permission TINYINT NOT NULL DEFAULT 0,
         */
        String islandsPermissionsQuery = "CREATE TABLE IF NOT EXISTS `sb_permissions`(`playerID` INT NOT NULL, `islandID` INT NOT NULL, `permission` TINYINT NOT NULL DEFAULT 0, PRIMARY KEY (`playerID`, `islandID`))Engine=InnoDB DEFAULT CHARSET=utf8;";
        // Execute the queries.
        mySQLConnector.executeUpdate(playerIndexQuery);
        mySQLConnector.executeUpdate(islandsIndexQuery);
        mySQLConnector.executeUpdate(islandsPermissionsQuery);
    }

    /**
     * Initializes a player's index.
     *
     * @param player Bukkit's player object.
     */
    protected void initializePlayer(Player player) {
        String initIndex = "INSERT INTO `sb_index`(`uuid`, `playerName`) VALUES (?,?) ON DUPLICATE KEY UPDATE `playerName`=?";
        mySQLConnector.executeQuery(initIndex, player.getUniqueId(), player.getName(), player.getName());
    }


}
