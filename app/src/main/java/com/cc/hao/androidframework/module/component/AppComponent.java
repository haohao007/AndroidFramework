package com.cc.hao.androidframework.module.component;


import com.cc.hao.androidframework.App;
import com.cc.hao.androidframework.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hao on 2015/8/15.
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {
    App inject(App app);
}
