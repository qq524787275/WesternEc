package com.wethis.module_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
