package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.entity.KOTamableEntity;
import net.jargneau.kotamingmod.entity.TorporEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Map;

@Mixin(HorseEntity.class)
public abstract class MixinHorseEntity extends LivingEntity implements TorporEntity, KOTamableEntity {

    private int torpor = 0;
    private final int BASETORPOR = Main.getBaseTorporConfig().baseHorseTorpor;

    protected MixinHorseEntity(EntityType<? extends LivingEntity> entityType, World world) {
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
    public Map<Item, Integer> getTamingFood() {
        return null;
    }

}
