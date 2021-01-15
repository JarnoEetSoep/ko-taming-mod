package net.jargneau.kotamingmod.items;

import net.jargneau.kotamingmod.Register;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Narcoberry extends Item {
    public Narcoberry() {
        super(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
                .hunger(1)
                .saturationModifier(1f)
                .snack()
                .alwaysEdible()
                .statusEffect(new StatusEffectInstance(Register.KNOCKOUT, 100), 1f)
                .build()));
    }
}
