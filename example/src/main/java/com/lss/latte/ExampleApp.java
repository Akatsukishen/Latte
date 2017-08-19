package com.lss.latte;

import android.app.Application;
import com.joanzapata.android.iconify.fonts.FontAwesomeModule;
import com.lss.latte.core.app.Latte;
import com.lss.latte.ec.icon.FontEcModule;

/**
 * Created by li.shensong on 19/08/2017.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .configure();
    }

}
