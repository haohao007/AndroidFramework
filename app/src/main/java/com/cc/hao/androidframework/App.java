package com.cc.hao.androidframework;

import android.app.Application;
import android.os.StrictMode;

import com.cc.hao.androidframework.module.AppModule;
import com.cc.hao.androidframework.module.component.AppComponent;
import com.cc.hao.androidframework.module.component.DaggerAppComponent;


/**
 * Created by hao on 2015/8/15.
 */
public class App extends Application{



    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //日志
//        if (BuildConfig.DEBUG){
//            Timber.plant(new Timber.DebugTree());
//        }else {
//            Timber.plant(CrashReportTree());
//        }

        //严苛模式调试
        if (Constant.DEVELOPER_MODE){
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDialog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyDeath()
                    .penaltyLog()
                    .build());
        }
        //mObjectGraph
        setupGraph();

    }

    private void setupGraph() {
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

}
