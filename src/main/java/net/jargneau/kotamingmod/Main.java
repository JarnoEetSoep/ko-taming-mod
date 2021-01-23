package net.jargneau.kotamingmod;

import me.lortseam.completeconfig.ConfigHandler;
import me.lortseam.completeconfig.data.Config;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.jargneau.kotamingmod.misc.MobInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.WorldSavePath;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main implements ModInitializer {

    public static final String MOD_ID = "kotaming";
    public static Map<String, MobInventory> mobInventories = new HashMap<>();
    public static List<String> playersOpenedInventory = new ArrayList<>();
    private static ConfigHandler configHandler;
    private static Configuration configuration;

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "itemgroup"))
            .icon(() -> new ItemStack(Register.TRANQ_ARROW))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(Register.NARCOBERRY));
                itemStacks.add(new ItemStack(Register.NARCOTIC));
                itemStacks.add(new ItemStack(Register.TRANQ_ARROW));
                itemStacks.add(new ItemStack(Items.BOW));
                itemStacks.add(new ItemStack(Items.CROSSBOW));
            }).build();

    @Override
    public void onInitialize() {
        Register.registerAll();

        configuration = new Configuration();
        configHandler = Config.builder(Main.MOD_ID)
                .add(configuration)
                .build();
    }

    public static void SavePlayerData(MinecraftServer server, PlayerEntity player) {
        File playerDataDir = server.getSavePath(WorldSavePath.PLAYERDATA).toFile();
        try {
            CompoundTag compoundTag = player.toTag(new CompoundTag());
            File file = File.createTempFile(player.getUuidAsString() + "-", ".dat", playerDataDir);
            NbtIo.writeCompressed(compoundTag, file);
            File file2 = new File(playerDataDir, player.getUuidAsString() + ".dat");
            File file3 = new File(playerDataDir, player.getUuidAsString() + ".dat_old");
            Util.backupAndReplace(file2, file, file3);
        } catch (Exception var6) {
            LogManager.getLogger().warn("Failed to save player data for {}", player.getName().getString());
        }
    }

    public static Configuration getConfig() {
        return configuration;
    }

    public static ConfigHandler getConfigHandler() {
        return configHandler;
    }

}
