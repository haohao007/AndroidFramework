package com.cc.hao.androidframework.ui.activity;


import com.cc.hao.androidframework.module.PresenterModule;
import com.cc.hao.androidframework.module.component.AppComponent;
import com.cc.hao.androidframework.module.component.DaggerPresenterComponent;
import com.cc.hao.androidframework.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {


    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void setupComponent(AppComponent appComponent) {

        DaggerPresenterComponent.builder()
                .appComponent(appComponent)
                .presenterModule(new PresenterModule())
                .build().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
