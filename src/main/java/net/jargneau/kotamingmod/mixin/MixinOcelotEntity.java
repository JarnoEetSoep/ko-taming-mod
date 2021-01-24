package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.Register;
import net.jargneau.kotamingmod.entity.InventoryMob;
import net.jargneau.kotamingmod.entity.KOTamableEntity;
import net.jargneau.kotamingmod.entity.TorporEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Mixin(OcelotEntity.class)
public abstract class MixinOcelotEntity extends LivingEntity implements TorporEntity, KOTamableEntity {

    @Shadow protected abstract void setTrusting(boolean trusting);

    private int torpor = 0;
    private final int BASETORPOR = Main.getBaseTorporConfig().baseOcelotTorpor;
    private int tamingPercent = 0;
    private PlayerEntity owner = null;
    private PlayerEntity knockedOutBy;

    protected MixinOcelotEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int getTorpor() {
        return this.torpor;
    }

    @Override
    public void setTorpor(int amount) {
        this.torpor = amount;

        if(this.torpor > this.BASETORPOR)
            this.torpor = this.BASETORPOR;

        if(this.torpor < 0)
            this.torpor = 0;
    }

    @Override
    public int getBaseTorpor() {
        return this.BASETORPOR;
    }

    @Override
    public void tickTorpor() {
        if(this.hasStatusEffect(Register.KNOCKOUT) && this.owner == null) {
            InventoryMob inventoryMob = (InventoryMob) this;

            if(this.age % (20 * Main.getGeneralConfiguration().tamingInterval) == 0) {
                for(Map<Item, Integer> tamingItem : this.getTamingFood()) {
                    if(inventoryMob.getInventory().containsAny(tamingItem.keySet())) {
                        inventoryMob.getInventory().removeItem(tamingItem.keySet().iterator().next(), 1);
                        this.tamingPercent += tamingItem.get(tamingItem.keySet().iterator().next());

                        if(this.tamingPercent >= 100) {
                            this.owner = knockedOutBy;
                            this.setTrusting(true);
                            this.torpor = 0;
                        }

                        break;
                    }
                }
            }
        }
    }

    @Override
    public void setKnockedOutBy(PlayerEntity player) {
        this.knockedOutBy = player;
    }

    @Override
    public ArrayList<Map<Item, Integer>> getTamingFood() {
        ArrayList<Map<Item, Integer>> tamingFood = new ArrayList<>();

        tamingFood.add(new HashMap<>());
        tamingFood.add(new HashMap<>());
        tamingFood.add(new HashMap<>());
        tamingFood.add(new HashMap<>());

        tamingFood.get(0).put(Items.TROPICAL_FISH, Math.round(65 * Main.getGeneralConfiguration().tamingSpeedMultiplier));
        tamingFood.get(1).put(Items.SALMON, Math.round(60 * Main.getGeneralConfiguration().tamingSpeedMultiplier));
        tamingFood.get(2).put(Items.COD, Math.round(50 * Main.getGeneralConfiguration().tamingSpeedMultiplier));
        tamingFood.get(3).put(Items.PUFFERFISH, Math.round(30 * Main.getGeneralConfiguration().tamingSpeedMultiplier));

        return tamingFood;
    }

}
