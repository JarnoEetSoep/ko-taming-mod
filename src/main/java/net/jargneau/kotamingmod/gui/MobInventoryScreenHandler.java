package net.jargneau.kotamingmod.gui;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.misc.MobInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class MobInventoryScreenHandler extends GenericContainerScreenHandler {

    public MobInventoryScreenHandler(int syncId, PlayerInventory playerInventory, MobInventory mobInventory, int rows) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory, mobInventory, rows);
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        Main.playersOpenedInventory.remove(player.getUuidAsString());
    }

}
