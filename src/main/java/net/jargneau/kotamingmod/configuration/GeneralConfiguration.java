package net.jargneau.kotamingmod.configuration;

import me.lortseam.completeconfig.api.ConfigGroup;

public class GeneralConfiguration implements ConfigGroup, SimpleConfiguration {

    public float tamingInterval = 5;
    public float tamingSpeedMultiplier = 1;

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

    @Override
    public Object getField(String key) {
        switch(key) {
            case "tamingInterval": return tamingInterval;
            case "tamingSpeedMultiplier": return tamingSpeedMultiplier;
            default: return -1;
        }
    }

    @Override
    public int setField(String key, Object value) {
        switch(key) {
            case "tamingInterval": tamingInterval = (float) value; return 1;
            case "tamingSpeedMultiplier": tamingSpeedMultiplier = (float) value; return 1;
            default: return -1;
        }
    }

}
