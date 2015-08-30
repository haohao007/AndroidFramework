package com.cc.hao.androidframework.module;

import android.app.Application;
import com.cc.hao.androidframework.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hao on 2015/8/15.
 */
@Module
public class AppModule {
    private App app;
    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}
