package net.jargneau.kotamingmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.configuration.SimpleConfiguration;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import java.util.concurrent.CompletableFuture;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.*;

public class ConfigCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> literalargumentbuilder = literal("config")
                .requires((source) -> source.hasPermissionLevel(4))
                .then(literal("GeneralConfiguration")
                        .then(argument("key", word()).suggests(ConfigCommand::suggestGeneralFields)
                                .executes((c) -> getField(c.getSource(), Main.getGeneralConfiguration(), getString(c, "key")))
                                .then(argument("value", greedyString())
                                        .executes((c) -> setField(c.getSource(), Main.getGeneralConfiguration(), getString(c, "key"), getString(c, "value"))))))
                .then(literal("BaseTorporConfiguration")
                        .then(argument("key", word()).suggests(ConfigCommand::suggestBaseTorporFields)
                                .executes((c) -> getField(c.getSource(), Main.getBaseTorporConfig(), getString(c, "key")))
                                .then(argument("value", greedyString())
                                        .executes((c) -> setField(c.getSource(), Main.getBaseTorporConfig(), getString(c, "key"), getString(c, "value"))))));

        dispatcher.register(literalargumentbuilder);
    }

    private static CompletableFuture<Suggestions> suggestGeneralFields(CommandContext<ServerCommandSource> context, SuggestionsBuilder suggestionsBuilder) {
        suggestionsBuilder.suggest("tamingInterval", new TranslatableText("config.kotaming.generalConfiguration.tamingInterval"));
        suggestionsBuilder.suggest("tamingSpeedMultiplier", new TranslatableText("config.kotaming.generalConfiguration.tamingSpeedMultiplier"));

        return suggestionsBuilder.buildFuture();
    }

    private static CompletableFuture<Suggestions> suggestBaseTorporFields(CommandContext<ServerCommandSource> context, SuggestionsBuilder suggestionsBuilder) {
        suggestionsBuilder.suggest("basePlayerTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePlayerTorpor"));
        suggestionsBuilder.suggest("baseChickenTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseChickenTorpor"));
        suggestionsBuilder.suggest("baseCowTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseCowTorpor"));
        suggestionsBuilder.suggest("baseDonkeyTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseDonkeyTorpor"));
        suggestionsBuilder.suggest("baseFoxTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseFoxTorpor"));
        suggestionsBuilder.suggest("baseHorseTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseHorseTorpor"));
        suggestionsBuilder.suggest("baseMooshroomTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseMooshroomTorpor"));
        suggestionsBuilder.suggest("baseMuleTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseMuleTorpor"));
        suggestionsBuilder.suggest("baseOcelotTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseOcelotTorpor"));
        suggestionsBuilder.suggest("baseParrotTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseParrotTorpor"));
        suggestionsBuilder.suggest("basePigTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePigTorpor"));
        suggestionsBuilder.suggest("basePolarBearTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePolarBearTorpor"));
        suggestionsBuilder.suggest("baseRabbitTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseRabbitTorpor"));
        suggestionsBuilder.suggest("baseLlamaTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseLlamaTorpor"));
        suggestionsBuilder.suggest("baseWolfTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseWolfTorpor"));
        suggestionsBuilder.suggest("baseBatTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseBatTorpor"));
        suggestionsBuilder.suggest("baseFishTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseFishTorpor"));
        suggestionsBuilder.suggest("baseSnowGolemTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSnowGolemTorpor"));
        suggestionsBuilder.suggest("baseIronGolemTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseIronGolemTorpor"));
        suggestionsBuilder.suggest("baseSquidTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSquidTorpor"));
        suggestionsBuilder.suggest("baseStriderTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseStriderTorpor"));
        suggestionsBuilder.suggest("baseTurtleTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseTurtleTorpor"));
        suggestionsBuilder.suggest("baseVillagerTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseVillagerTorpor"));
        suggestionsBuilder.suggest("baseIllagerTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseIllagerTorpor"));
        suggestionsBuilder.suggest("baseBeeTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseBeeTorpor"));
        suggestionsBuilder.suggest("baseSpiderTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSpiderTorpor"));
        suggestionsBuilder.suggest("baseCaveSpiderTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseCaveSpiderTorpor"));
        suggestionsBuilder.suggest("baseDolphinTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseDolphinTorpor"));
        suggestionsBuilder.suggest("baseEndermanTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseEndermanTorpor"));
        suggestionsBuilder.suggest("basePandaTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePandaTorpor"));
        suggestionsBuilder.suggest("baseZombifiedPiglinTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseZombifiedPiglinTorpor"));
        suggestionsBuilder.suggest("basePiglinTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePiglinTorpor"));
        suggestionsBuilder.suggest("baseBlazeTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseBlazeTorpor"));
        suggestionsBuilder.suggest("baseCreeperTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseCreeperTorpor"));
        suggestionsBuilder.suggest("baseDrownedTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseDrownedTorpor"));
        suggestionsBuilder.suggest("baseZombieTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseZombieTorpor"));
        suggestionsBuilder.suggest("baseElderGuardianTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseElderGuardianTorpor"));
        suggestionsBuilder.suggest("baseGuardianTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseGuardianTorpor"));
        suggestionsBuilder.suggest("baseEndermiteTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseEndermiteTorpor"));
        suggestionsBuilder.suggest("baseSilverfishTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSilverfishTorpor"));
        suggestionsBuilder.suggest("baseGhastTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseGhastTorpor"));
        suggestionsBuilder.suggest("baseHoglinTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseHoglinTorpor"));
        suggestionsBuilder.suggest("baseZoglinTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseZoglinTorpor"));
        suggestionsBuilder.suggest("baseSlimeTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSlimeTorpor"));
        suggestionsBuilder.suggest("baseMagmaCubeTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseMagmaCubeTorpor"));
        suggestionsBuilder.suggest("basePhantomTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePhantomTorpor"));
        suggestionsBuilder.suggest("basePiglinBruteTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.basePiglinBruteTorpor"));
        suggestionsBuilder.suggest("baseRavagerTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseRavagerTorpor"));
        suggestionsBuilder.suggest("baseShulkerTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseShulkerTorpor"));
        suggestionsBuilder.suggest("baseSkeletonTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseSkeletonTorpor"));
        suggestionsBuilder.suggest("baseWitherSkeletonTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseWitherSkeletonTorpor"));
        suggestionsBuilder.suggest("baseVexTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseVexTorpor"));
        suggestionsBuilder.suggest("baseWitchTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseWitchTorpor"));
        suggestionsBuilder.suggest("baseHuskTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseHuskTorpor"));
        suggestionsBuilder.suggest("baseStrayTorpor", new TranslatableText("config.kotaming.baseTorporConfiguration.baseStrayTorpor"));

        return suggestionsBuilder.buildFuture();
    }

    private static int getField(ServerCommandSource source, SimpleConfiguration config, String key) {
        Object value = config.getField(key);

        if(value instanceof Integer && (int) value == -1) {
            source.sendFeedback(new TranslatableText("command.getfield.failed"), false);
            return -1;
        }

        source.sendFeedback(new LiteralText(key + " : " + value.toString()), false);
        return 1;
    }

    private static int setField(ServerCommandSource source, SimpleConfiguration config, String key, String value) {
        if(config.getField(key) instanceof Integer) {
            if(!isInt(value)) {
                source.sendFeedback(new TranslatableText("command.setfield.failed.noint"), false);
                return -1;
            }
        } else if(config.getField(key) instanceof Float) {
            if(!isFloat(value)) {
                source.sendFeedback(new TranslatableText("command.setfield.failed.nofloat"), false);
                return -1;
            }
        } else if(config.getField(key) instanceof Boolean) {
            if(!isBool(value)) {
                source.sendFeedback(new TranslatableText("command.setfield.failed.nobool"), false);
                return -1;
            }
        }

        int result = config.setField(key, value);

        if(result == -1) {
            source.sendFeedback(new TranslatableText("command.setfield.failed"), false);
            return -1;
        }

        source.sendFeedback(new LiteralText(key + " -> " + config.getField(key).toString()), false);
        return 1;
    }

    private static boolean isInt(String v) {
        try {
            Integer.parseInt(v);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String v) {
        try {
            Float.parseFloat(v);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBool(String v) {
        try {
            Boolean.parseBoolean(v);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
