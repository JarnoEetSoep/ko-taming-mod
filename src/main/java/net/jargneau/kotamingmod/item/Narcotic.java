package net.jargneau.kotamingmod.item;

import net.jargneau.kotamingmod.Register;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class Narcotic extends Item {

    public Narcotic() {
        super(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
                .hunger(1)
                .saturationModifier(1f)
                .alwaysEdible()
                .statusEffect(new StatusEffectInstance(Register.KNOCKOUT, 800), 1f)
                .build()));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText("kotaming.narcotic.flavor_text"));
    }

}
