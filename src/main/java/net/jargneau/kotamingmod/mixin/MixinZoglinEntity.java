package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.entity.TorporEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZoglinEntity.class)
public abstract class MixinZoglinEntity extends LivingEntity implements TorporEntity {

    private int torpor = 0;
    private final int BASETORPOR = Main.getBaseTorporConfig().baseZoglinTorpor;

    protected MixinZoglinEntity(EntityType<? extends LivingEntity> entityType, World world) {
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

}
