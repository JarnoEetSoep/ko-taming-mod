package net.jargneau.kotamingmod.item;

import net.jargneau.kotamingmod.Register;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Narcotic extends Item {
    public Narcotic() {
        super(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
                .hunger(1)
                .saturationModifier(1f)
                .alwaysEdible()
                .statusEffect(new StatusEffectInstance(Register.KNOCKOUT, 800), 1f)
                .build()));
    }
}
