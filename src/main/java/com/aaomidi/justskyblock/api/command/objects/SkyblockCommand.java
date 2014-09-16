package com.aaomidi.justskyblock.api.command.objects;

import com.aaomidi.justskyblock.api.command.interfaces.SkyblockCommandInterface;
import com.avaje.ebean.validation.NotNull;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author aaomidi
 */

public class SkyblockCommand {
    @Getter
    @NotNull
    private SkyblockCommandInterface executor;
    @Getter
    @NonNull
    private JavaPlugin instance;
    @Getter
    @NonNull
    private String commandLabel;
    @Getter
    @NonNull
    private boolean forcePlayer;
    @Getter
    @NonNull
    private String usage;
    @Getter
    @NonNull
    private String[] aliases;

    public SkyblockCommand(SkyblockCommandInterface executor, JavaPlugin instance, String commandLabel, boolean forcePlayer, String usage, String... aliases) {
        this.executor = executor;
        this.instance = instance;
        this.commandLabel = commandLabel;
        this.forcePlayer = forcePlayer;
        this.usage = usage;
        this.aliases = aliases;
    }

}
