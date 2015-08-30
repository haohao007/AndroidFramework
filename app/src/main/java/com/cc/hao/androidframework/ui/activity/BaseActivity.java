package com.cc.hao.androidframework.ui.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cc.hao.androidframework.PresenterHandler;
import com.cc.hao.androidframework.module.component.AppComponent;
import com.cc.hao.androidframework.presenter.MainPresenter;
import com.cc.hao.androidframework.presenter.Presenter;
import com.cc.hao.androidframework.presenter.UserPresenter;
import com.cc.hao.androidframework.ui.display.Display;

import java.lang.reflect.Proxy;


/**
 * Created by hao on 2015/8/16.
 */
public abstract class BaseActivity extends Activity {

    Display mDisplay;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //动态代理
        Presenter p=(Presenter)Proxy.newProxyInstance(
                Presenter.class.getClassLoader(),
                new Class[]{MainPresenter.class, UserPresenter.class},
                new PresenterHandler(presenter)
        );
        p.attachDisplay(mDisplay);
        p.init();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        //动态代理
        Presenter p=(Presenter)Proxy.newProxyInstance(
                Presenter.class.getClassLoader(),
                new Class[]{MainPresenter.class, UserPresenter.class},
                new PresenterHandler(presenter)
        );
        p.suspend();
        p.detachDisplay(mDisplay);
        super.onPause();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisplay = null;
    }

    public Display getDisplay() {
        return mDisplay;
    }

    protected abstract void setupComponent(AppComponent appComponent);

    public void setPresenter(Presenter presenter){
        this.presenter=presenter;
    }



}
