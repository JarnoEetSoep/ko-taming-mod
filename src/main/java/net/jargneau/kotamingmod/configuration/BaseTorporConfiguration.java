package net.jargneau.kotamingmod.configuration;

import me.lortseam.completeconfig.api.ConfigGroup;

public class BaseTorporConfiguration implements ConfigGroup, SimpleConfiguration {

    // Al tameable creatures
    public int basePlayerTorpor = 200;
    public int baseChickenTorpor = 40;
    public int baseCowTorpor = 250;
    public int baseDonkeyTorpor = 400;
    public int baseFoxTorpor = 100;
    public int baseHorseTorpor = 400;
    public int baseMooshroomTorpor = 250;
    public int baseMuleTorpor = 400;
    public int baseOcelotTorpor = 100;
    public int baseParrotTorpor = 40;
    public int basePigTorpor = 200;
    public int basePolarBearTorpor = 400;
    public int baseRabbitTorpor = 40;
    public int baseSheepTorpor = 200;
    public int baseLlamaTorpor = 400;
    public int baseWolfTorpor = 100;

    // All non-tameable creatures
    public int baseBatTorpor = 20;
    public int baseFishTorpor = 20;
    public int baseSnowGolemTorpor = 200;
    public int baseIronGolemTorpor = 1000;
    public int baseSquidTorpor = 150;
    public int baseStriderTorpor = 200;
    public int baseTurtleTorpor = 500;
    public int baseVillagerTorpor = 200;
    public int baseIllagerTorpor = 250;
    public int baseBeeTorpor = 20;
    public int baseSpiderTorpor = 150;
    public int baseCaveSpiderTorpor = 100;
    public int baseDolphinTorpor = 250;
    public int baseEndermanTorpor = 250;
    public int basePandaTorpor = 400;
    public int baseZombifiedPiglinTorpor = 200;
    public int basePiglinTorpor = 200;
    public int baseBlazeTorpor = 250;
    public int baseCreeperTorpor = 250;
    public int baseDrownedTorpor = 250;
    public int baseZombieTorpor = 250;
    public int baseElderGuardianTorpor = 1000;
    public int baseGuardianTorpor = 500;
    public int baseEndermiteTorpor = 20;
    public int baseSilverfishTorpor = 20;
    public int baseGhastTorpor = 250;
    public int baseHoglinTorpor = 400;
    public int baseZoglinTorpor = 500;
    // For each size increment +100
    public int baseSlimeTorpor = 100;
    public int baseMagmaCubeTorpor = 150;
    public int basePhantomTorpor = 100;
    public int basePiglinBruteTorpor = 400;
    public int baseRavagerTorpor = 1000;
    public int baseShulkerTorpor = 200;
    public int baseSkeletonTorpor = 250;
    public int baseWitherSkeletonTorpor = 300;
    public int baseVexTorpor = 20;
    public int baseWitchTorpor = 250;
    public int baseHuskTorpor = 250;
    public int baseStrayTorpor = 250;

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

    @Override
    public Object getField(String key) {
        switch(key) {
            case "basePlayerTorpor": return basePlayerTorpor;
            case "baseChickenTorpor": return baseChickenTorpor;
            case "baseCowTorpor": return baseCowTorpor;
            case "baseDonkeyTorpor": return baseDonkeyTorpor;
            case "baseFoxTorpor": return baseFoxTorpor;
            case "baseHorseTorpor": return baseHorseTorpor;
            case "baseMooshroomTorpor": return baseMooshroomTorpor;
            case "baseMuleTorpor": return baseMuleTorpor;
            case "baseOcelotTorpor": return baseOcelotTorpor;
            case "baseParrotTorpor": return baseParrotTorpor;
            case "basePigTorpor": return basePigTorpor;
            case "basePolarBearTorpor": return basePolarBearTorpor;
            case "baseRabbitTorpor": return baseRabbitTorpor;
            case "baseSheepTorpor": return baseSheepTorpor;
            case "baseLlamaTorpor": return baseLlamaTorpor;
            case "baseWolfTorpor": return baseWolfTorpor;
            case "baseBatTorpor": return baseBatTorpor;
            case "baseFishTorpor": return baseFishTorpor;
            case "baseSnowGolemTorpor": return baseSnowGolemTorpor;
            case "baseIronGolemTorpor": return baseIronGolemTorpor;
            case "baseSquidTorpor": return baseSquidTorpor;
            case "baseStriderTorpor": return baseStriderTorpor;
            case "baseTurtleTorpor": return baseTurtleTorpor;
            case "baseVillagerTorpor": return baseVillagerTorpor;
            case "baseIllagerTorpor": return baseIllagerTorpor;
            case "baseBeeTorpor": return baseBeeTorpor;
            case "baseSpiderTorpor": return baseSpiderTorpor;
            case "baseCaveSpiderTorpor": return baseCaveSpiderTorpor;
            case "baseDolphinTorpor": return baseDolphinTorpor;
            case "baseEndermanTorpor": return baseEndermanTorpor;
            case "basePandaTorpor": return basePandaTorpor;
            case "baseZombifiedPiglinTorpor": return baseZombifiedPiglinTorpor;
            case "basePiglinTorpor": return basePiglinTorpor;
            case "baseBlazeTorpor": return baseBlazeTorpor;
            case "baseCreeperTorpor": return baseCreeperTorpor;
            case "baseDrownedTorpor": return baseDrownedTorpor;
            case "baseZombieTorpor": return baseZombieTorpor;
            case "baseElderGuardianTorpor": return baseElderGuardianTorpor;
            case "baseGuardianTorpor": return baseGuardianTorpor;
            case "baseEndermiteTorpor": return baseEndermiteTorpor;
            case "baseSilverfishTorpor": return baseSilverfishTorpor;
            case "baseGhastTorpor": return baseGhastTorpor;
            case "baseHoglinTorpor": return baseHoglinTorpor;
            case "baseZoglinTorpor": return baseZoglinTorpor;
            case "baseSlimeTorpor": return baseSlimeTorpor;
            case "baseMagmaCubeTorpor": return baseMagmaCubeTorpor;
            case "basePhantomTorpor": return basePhantomTorpor;
            case "basePiglinBruteTorpor": return basePiglinBruteTorpor;
            case "baseRavagerTorpor": return baseRavagerTorpor;
            case "baseShulkerTorpor": return baseShulkerTorpor;
            case "baseSkeletonTorpor": return baseSkeletonTorpor;
            case "baseWitherSkeletonTorpor": return baseWitherSkeletonTorpor;
            case "baseVexTorpor": return baseVexTorpor;
            case "baseWitchTorpor": return baseWitchTorpor;
            case "baseHuskTorpor": return baseHuskTorpor;
            case "baseStrayTorpor": return baseStrayTorpor;
            default: return -1;
        }
    }

    @Override
    public int setField(String key, String value) {
        switch(key) {
            case "basePlayerTorpor": basePlayerTorpor = Integer.parseInt(value); return 1;
            case "baseChickenTorpor": baseChickenTorpor = Integer.parseInt(value); return 1;
            case "baseCowTorpor": baseCowTorpor = Integer.parseInt(value); return 1;
            case "baseDonkeyTorpor": baseDonkeyTorpor = Integer.parseInt(value); return 1;
            case "baseFoxTorpor": baseFoxTorpor = Integer.parseInt(value); return 1;
            case "baseHorseTorpor": baseHorseTorpor = Integer.parseInt(value); return 1;
            case "baseMooshroomTorpor": baseMooshroomTorpor = Integer.parseInt(value); return 1;
            case "baseMuleTorpor": baseMuleTorpor = Integer.parseInt(value); return 1;
            case "baseOcelotTorpor": baseOcelotTorpor = Integer.parseInt(value); return 1;
            case "baseParrotTorpor": baseParrotTorpor = Integer.parseInt(value); return 1;
            case "basePigTorpor": basePigTorpor = Integer.parseInt(value); return 1;
            case "basePolarBearTorpor": basePolarBearTorpor = Integer.parseInt(value); return 1;
            case "baseRabbitTorpor": baseRabbitTorpor = Integer.parseInt(value); return 1;
            case "baseSheepTorpor": baseSheepTorpor = Integer.parseInt(value); return 1;
            case "baseLlamaTorpor": baseLlamaTorpor = Integer.parseInt(value); return 1;
            case "baseWolfTorpor": baseWolfTorpor = Integer.parseInt(value); return 1;
            case "baseBatTorpor": baseBatTorpor = Integer.parseInt(value); return 1;
            case "baseFishTorpor": baseFishTorpor = Integer.parseInt(value); return 1;
            case "baseSnowGolemTorpor": baseSnowGolemTorpor = Integer.parseInt(value); return 1;
            case "baseIronGolemTorpor": baseIronGolemTorpor = Integer.parseInt(value); return 1;
            case "baseSquidTorpor": baseSquidTorpor = Integer.parseInt(value); return 1;
            case "baseStriderTorpor": baseStriderTorpor = Integer.parseInt(value); return 1;
            case "baseTurtleTorpor": baseTurtleTorpor = Integer.parseInt(value); return 1;
            case "baseVillagerTorpor": baseVillagerTorpor = Integer.parseInt(value); return 1;
            case "baseIllagerTorpor": baseIllagerTorpor = Integer.parseInt(value); return 1;
            case "baseBeeTorpor": baseBeeTorpor = Integer.parseInt(value); return 1;
            case "baseSpiderTorpor": baseSpiderTorpor = Integer.parseInt(value); return 1;
            case "baseCaveSpiderTorpor": baseCaveSpiderTorpor = Integer.parseInt(value); return 1;
            case "baseDolphinTorpor": baseDolphinTorpor = Integer.parseInt(value); return 1;
            case "baseEndermanTorpor": baseEndermanTorpor = Integer.parseInt(value); return 1;
            case "basePandaTorpor": basePandaTorpor = Integer.parseInt(value); return 1;
            case "baseZombifiedPiglinTorpor": baseZombifiedPiglinTorpor = Integer.parseInt(value); return 1;
            case "basePiglinTorpor": basePiglinTorpor = Integer.parseInt(value); return 1;
            case "baseBlazeTorpor": baseBlazeTorpor = Integer.parseInt(value); return 1;
            case "baseCreeperTorpor": baseCreeperTorpor = Integer.parseInt(value); return 1;
            case "baseDrownedTorpor": baseDrownedTorpor = Integer.parseInt(value); return 1;
            case "baseZombieTorpor": baseZombieTorpor = Integer.parseInt(value); return 1;
            case "baseElderGuardianTorpor": baseElderGuardianTorpor = Integer.parseInt(value); return 1;
            case "baseGuardianTorpor": baseGuardianTorpor = Integer.parseInt(value); return 1;
            case "baseEndermiteTorpor": baseEndermiteTorpor = Integer.parseInt(value); return 1;
            case "baseSilverfishTorpor": baseSilverfishTorpor = Integer.parseInt(value); return 1;
            case "baseGhastTorpor": baseGhastTorpor = Integer.parseInt(value); return 1;
            case "baseHoglinTorpor": baseHoglinTorpor = Integer.parseInt(value); return 1;
            case "baseZoglinTorpor": baseZoglinTorpor = Integer.parseInt(value); return 1;
            case "baseSlimeTorpor": baseSlimeTorpor = Integer.parseInt(value); return 1;
            case "baseMagmaCubeTorpor": baseMagmaCubeTorpor = Integer.parseInt(value); return 1;
            case "basePhantomTorpor": basePhantomTorpor = Integer.parseInt(value); return 1;
            case "basePiglinBruteTorpor": basePiglinBruteTorpor = Integer.parseInt(value); return 1;
            case "baseRavagerTorpor": baseRavagerTorpor = Integer.parseInt(value); return 1;
            case "baseShulkerTorpor": baseShulkerTorpor = Integer.parseInt(value); return 1;
            case "baseSkeletonTorpor": baseSkeletonTorpor = Integer.parseInt(value); return 1;
            case "baseWitherSkeletonTorpor": baseWitherSkeletonTorpor = Integer.parseInt(value); return 1;
            case "baseVexTorpor": baseVexTorpor = Integer.parseInt(value); return 1;
            case "baseWitchTorpor": baseWitchTorpor = Integer.parseInt(value); return 1;
            case "baseHuskTorpor": baseHuskTorpor = Integer.parseInt(value); return 1;
            case "baseStrayTorpor": baseStrayTorpor = Integer.parseInt(value); return 1;
            default: return -1;
        }
    }

}
