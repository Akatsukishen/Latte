package com.lss.latte.core.app;

import java.util.HashMap;

/**
 * Created by li.shensong on 19/08/2017.
 */

public class Configurator {

    private static final HashMap<String,Object> LATTE_CONFIGS = new HashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }


    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    //单例
    private static class Holder{
        private static Configurator INSTANCE = new Configurator();
    }

    public final HashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady =(boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready!");
        }
    }

    final <T> T getConfiguration(ConfigType key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}