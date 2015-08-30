package com.cc.hao.androidframework.module;


import com.cc.hao.androidframework.presenter.MainPresenter;
import com.cc.hao.androidframework.presenter.UserPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hao on 2015/8/17.
 */
@Module
public class PresenterModule {

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    public UserPresenter provideUserPresenter(){
        return new UserPresenter();
    }

}
