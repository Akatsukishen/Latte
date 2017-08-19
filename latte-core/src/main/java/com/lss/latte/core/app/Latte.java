package com.lss.latte.core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by li.shensong on 19/08/2017.
 */

public final class Latte {

    public static Configurator init(Context appContext){
        getConfigurations().put(ConfigType.APPLICTION_CONTEXT.name(),appContext);
        return Configurator.getInstance();
    }

    private static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
      return (Context) getConfigurations().get(ConfigType.APPLICTION_CONTEXT.name());
    }
}
