package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);
    @Shadow public abstract void stopRiding();

    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tickMovement", cancellable = true)
    public void tickMovement(CallbackInfo ci) {
        if(hasStatusEffect(Register.KNOCKOUT)) {
            if(hasVehicle())
                stopRiding();

            ci.cancel();
        }
    }

}
