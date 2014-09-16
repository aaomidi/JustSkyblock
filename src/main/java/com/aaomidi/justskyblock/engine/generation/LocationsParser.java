package com.aaomidi.justskyblock.engine.generation;


import com.aaomidi.justskyblock.JustSkyblock;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.World;

public class LocationsParser {
    private final JustSkyblock instance;

    public LocationsParser(JustSkyblock instance) {
        this.instance = instance;
    }

    /**
     * Change Bukkit's vector into WorldEdit's.
     *
     * @param vector Bukkit's vector.
     * @return WorldEdit's vector.
     */
    public static Vector bukkitVectorToWorldEditVector(org.bukkit.util.Vector vector) {
        return new Vector(vector.getX(), vector.getZ(), vector.getY());
    }

    /**
     * Change WorldEdit's vector into Bukkit's.
     *
     * @param vector WorldEdit's vector.
     * @return Bukkit's vector.
     */
    public static org.bukkit.util.Vector worldEditVectorToBukkitVector(Vector vector) {
        return new org.bukkit.util.Vector(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Construct a WorldEdit Region from WorldEdit's vectors.
     *
     * @param v1 Vector 1
     * @param v2 Vector 2
     * @return Region.
     */
    public static Region getRegion(Vector v1, Vector v2) {
        return new CuboidRegion(v1, v2);
    }

    /**
     * Construct a WorldEdit Region from Bukkit's vectors.
     *
     * @param v1 Vector 1
     * @param v2 Vector 2
     * @return Region.
     */
    public static Region getRegion(org.bukkit.util.Vector v1, org.bukkit.util.Vector v2) {
        return new CuboidRegion(bukkitVectorToWorldEditVector(v1), bukkitVectorToWorldEditVector(v2));
    }

    /**
     * Construct a WorldEdit world from a Bukkit world.
     *
     * @param world Bukkit's world.
     * @return WorldEdit's world.
     */
    public static LocalWorld getWorldEditWorld(World world) {
        return new BukkitWorld(world);
    }

}
