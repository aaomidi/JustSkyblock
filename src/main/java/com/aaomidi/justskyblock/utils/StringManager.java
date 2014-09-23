package com.aaomidi.justskyblock.utils;

import com.aaomidi.justskyblock.configuration.ConfigReader;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * @author aaomidi
 */
public class StringManager {
    public static void sendMessage(CommandSender commandSender, String message) {
        message = ConfigReader.getPrefix() + message;
        message = colorize(message);
        commandSender.sendMessage(message);
    }

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }


}
