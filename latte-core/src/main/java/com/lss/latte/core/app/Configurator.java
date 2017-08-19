package com.lss.latte.core.app;

import com.joanzapata.android.iconify.IconFontDescriptor;
import com.joanzapata.android.iconify.Iconify;
import com.joanzapata.android.iconify.Iconify.IconifyInitializer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by li.shensong on 19/08/2017.
 */

public class Configurator {

    private static final HashMap<String,Object> LATTE_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

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
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    private void initIcons(){
        if(ICONS.size() > 0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i = 1 ; i < ICONS.size() ; i++){
                initializer.with(ICONS.get(i));
            }
        }
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
