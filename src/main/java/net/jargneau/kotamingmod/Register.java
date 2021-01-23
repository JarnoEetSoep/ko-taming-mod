package net.jargneau.kotamingmod;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jargneau.kotamingmod.command.ConfigCommand;
import net.jargneau.kotamingmod.entity.TranqArrowEntity;
import net.jargneau.kotamingmod.item.Narcoberry;
import net.jargneau.kotamingmod.item.Narcotic;
import net.jargneau.kotamingmod.item.TranqArrow;
import net.jargneau.kotamingmod.statuseffect.Knockout;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

    public static final StatusEffect KNOCKOUT = new Knockout();

    public static final Item NARCOBERRY = new Narcoberry();
    public static final Item NARCOTIC = new Narcotic();
    public static final Item TRANQ_ARROW = new TranqArrow();

    public static final EntityType<TranqArrowEntity> TRANQ_ARROW_ENTITYTYPE = FabricEntityTypeBuilder.<TranqArrowEntity>create(SpawnGroup.MISC, TranqArrowEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).trackRangeBlocks(4).trackedUpdateRate(20).build();

    public static void registerAll() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Main.MOD_ID, "knockout"), KNOCKOUT);

        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "narcoberry"), NARCOBERRY);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "narcotic"), NARCOTIC);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "tranq_arrow"), TRANQ_ARROW);

        Registry.register(Registry.ENTITY_TYPE, new Identifier(Main.MOD_ID, "tranq_arrow"), TRANQ_ARROW_ENTITYTYPE);

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> ConfigCommand.register(dispatcher));
    }

}
