package net.jargneau.kotamingmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {

    public static final String MOD_ID = "kotaming";

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
    }

}
