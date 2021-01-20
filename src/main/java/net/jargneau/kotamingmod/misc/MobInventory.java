package net.jargneau.kotamingmod.misc;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

public class MobInventory extends SimpleInventory {

    public final MobEntity mob;
    public final Iterable<ItemStack> handItems;
    public final Iterable<ItemStack> armorItems;

    public MobInventory(MobEntity mob) {
        super(27);
        this.mob = mob;
        this.handItems = mob.getItemsHand();
        this.armorItems = mob.getArmorItems();
    }

    public void readTags(ListTag tags) {
        int j;
        for(j = 0; j < this.size(); ++j) {
            this.setStack(j, ItemStack.EMPTY);
        }

        for(j = 0; j < tags.size(); ++j) {
            CompoundTag compoundTag = tags.getCompound(j);
            int k = compoundTag.getByte("Slot") & 255;
            if (k >= 0 && k < this.size()) {
                this.setStack(k, ItemStack.fromTag(compoundTag));
            }
        }

    }

    public ListTag getTags() {
        ListTag listTag = new ListTag();

        for(int i = 0; i < this.size(); ++i) {
            ItemStack itemStack = this.getStack(i);
            if (!itemStack.isEmpty()) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putByte("Slot", (byte)i);
                itemStack.toTag(compoundTag);
                listTag.add(compoundTag);
            }
        }

        return listTag;
    }

    public void dropInventory() {
        for(int slot = 0; slot < size(); slot++) {
            mob.dropStack(removeStack(slot));
        }
    }

    public boolean canPlayerUse(PlayerEntity player) {
        return (this.mob == null || this.mob.squaredDistanceTo(player) <= 64.0D) && super.canPlayerUse(player);
    }

    public void onOpen(PlayerEntity player) {
        super.onOpen(player);
    }

    public void onClose(PlayerEntity player) {
        super.onClose(player);
    }

}