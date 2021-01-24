package net.jargneau.kotamingmod.configuration;

public interface SimpleConfiguration {

    Object getField(String key);

    int setField(String key, String value);

}
