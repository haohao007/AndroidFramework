package com.cc.hao.androidframework.module.component;

import android.content.Context;

import com.cc.hao.androidframework.module.PresenterModule;
import com.cc.hao.androidframework.module.scope.ActivityScope;

import dagger.Component;

/**
 * Created by hao on 2015/8/17.
 */
@Component(
        dependencies = AppComponent.class,
        modules = PresenterModule.class
)
@ActivityScope
public interface PresenterComponent {
    void inject(Context context);
}
