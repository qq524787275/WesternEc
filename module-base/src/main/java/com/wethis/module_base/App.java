package com.wethis.module_base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

public class App extends Application {
    private static Context content;

    public static Context getContent() {
        return content;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        content = this;
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        //LOGGER 日志
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
    }
}
