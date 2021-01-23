package net.jargneau.kotamingmod.configuration;

import me.lortseam.completeconfig.api.ConfigGroup;

public class GeneralConfiguration implements ConfigGroup, SimpleConfiguration {

    public boolean goodmod = true;

    @Override
    public boolean isConfigPOJO() {
        return true;
    }

    @Override
    public Object getField(String key) {
        switch(key) {
            case "goodmod": return goodmod;
            default: return -1;
        }
    }

    @Override
    public int setField(String key, Object value) {
        switch(key) {
            case "goodmod": goodmod = (boolean) value; return 1;
            default: return -1;
        }
    }

}
