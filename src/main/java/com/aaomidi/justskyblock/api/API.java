package com.aaomidi.justskyblock.api;

import com.aaomidi.justskyblock.JustSkyblock;
import com.aaomidi.justskyblock.api.objects.SkyblockCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

/**
 * @author aaomidi
 */
public class API implements CommandExecutor {
    private final JustSkyblock instance;
    private final HashMap<String, SkyblockCommand> registeredCommands;

    public API(JustSkyblock instance) {
        this.instance = instance;
        registeredCommands = new HashMap<>();
        instance.getCommand("is").setExecutor(this);
    }

    public void registerCommand(SkyblockCommand skyblockCommand) {
        registeredCommands.put(skyblockCommand.getCommandLabel(), skyblockCommand);
        if (skyblockCommand.getAliases() == null || skyblockCommand.getAliases().length == 0) {
            return;
        }
        for (String alias : skyblockCommand.getAliases()) {
            registeredCommands.put(alias, skyblockCommand);
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("is")) {
            if (args.length == 0) {
                // Send information about all the registered commands.
                return true;
            }
            String subCommand = args[0];
            if (!registeredCommands.containsKey(subCommand)) {
                //Send command not found.
                return true;
            }
            SkyblockCommand skyblockCommand = registeredCommands.get(subCommand);


        }
        return true;
    }
}
