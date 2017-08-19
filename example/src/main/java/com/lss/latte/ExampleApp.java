package com.lss.latte;

import android.app.Application;

import com.lss.latte.core.app.Latte;

/**
 * Created by li.shensong on 19/08/2017.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .configure();
    }

}
