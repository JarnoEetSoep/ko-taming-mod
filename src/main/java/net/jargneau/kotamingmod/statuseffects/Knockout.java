package net.jargneau.kotamingmod.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class Knockout extends StatusEffect {

    public Knockout() {
        super(StatusEffectType.HARMFUL, 0x9e41ac);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            player.sendMessage(Text.of("You are KO"), false);
        }
    }

}
