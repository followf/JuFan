package com.bawei.feng.jufan;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initSDk();

    }

    private void initSDk() {

        Fresco.initialize(this);
    }
}
