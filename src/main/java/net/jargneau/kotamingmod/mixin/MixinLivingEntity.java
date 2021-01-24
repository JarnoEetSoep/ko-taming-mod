package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.Register;
import net.jargneau.kotamingmod.entity.TorporEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);
    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);
    @Shadow public abstract void stopRiding();

    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tickMovement", cancellable = true)
    public void tickMovement(CallbackInfo ci) {
        if(this instanceof TorporEntity) {
            TorporEntity self = (TorporEntity) this;

            if(self.getTorpor() == self.getBaseTorpor() || (this.hasStatusEffect(Register.KNOCKOUT) && self.getTorpor() != 0))
                this.addStatusEffect(new StatusEffectInstance(Register.KNOCKOUT, 20));

            if(age % 50 == 0 && self.getTorpor() != 0)
                self.setTorpor(self.getTorpor() - 4);

            if(this.hasStatusEffect(Register.KNOCKOUT)) {
                if(this.hasVehicle())
                    this.stopRiding();

                self.tickTorpor();

                ci.cancel();
            }
        }
    }

}
