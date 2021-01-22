package net.jargneau.kotamingmod.item;

import net.jargneau.kotamingmod.entity.TranqArrowEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class TranqArrow extends ArrowItem {

    public TranqArrow() {
        super(new Item.Settings().group(ItemGroup.COMBAT));
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new TranqArrowEntity(shooter, world);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText("kotaming.tranq_arrow.flavor_text"));
    }

}
