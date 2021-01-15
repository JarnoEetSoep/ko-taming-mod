package net.jargneau.kotamingmod;

import net.jargneau.kotamingmod.items.Narcoberry;
import net.jargneau.kotamingmod.items.Narcotic;
import net.jargneau.kotamingmod.items.TranqArrow;
import net.jargneau.kotamingmod.statuseffects.Knockout;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

    public static final StatusEffect KNOCKOUT = new Knockout();

    public static final Item NARCOBERRY = new Narcoberry();
    public static final Item NARCOTIC = new Narcotic();
    public static final Item TRANQ_ARROW = new TranqArrow();

    public static void registerAll() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Main.MOD_ID, "knockout"), KNOCKOUT);

        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "narcoberry"), NARCOBERRY);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "narcotic"), NARCOTIC);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "tranq_arrow"), TRANQ_ARROW);
    }

}
