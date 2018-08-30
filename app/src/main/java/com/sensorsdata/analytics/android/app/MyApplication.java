package com.sensorsdata.analytics.android.app;

import android.app.Application;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

/**
 * Created by 王灼洲 on 2018/7/22
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initSensorsDataAPI(this);
    }

    /**
     * 初始化埋点 SDK
     *
     * @param application Application
     */
    private void initSensorsDataAPI(Application application) {
        SensorsDataAPI.init(application);
    }
}
