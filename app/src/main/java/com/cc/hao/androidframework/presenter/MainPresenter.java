package com.cc.hao.androidframework.presenter;

import com.cc.hao.androidframework.ui.display.Display;

/**
 * Created by hao on 2015/8/16.
 */
public class MainPresenter extends BaseUiPresenter<MainPresenter.MainPrenterUi,MainPresenter.MainPrenterCallBack>{

    private static final String LOG_TAG =MainPresenter.class.getName();

    public interface MainPrenterUi extends BaseUiPresenter.Ui<MainPrenterCallBack>{}

    //一般UI事件回调
    public interface MainPrenterCallBack {

    }

    @Override
    protected MainPrenterCallBack createUiCallbacks(MainPrenterUi ui) {
        return new MainPrenterCallBack() {

        };
    }

    public MainPresenter(){

    }

    @Override
    protected void onInited() {
        super.onInited();

    }



    @Override
    protected void setDisplay(Display display) {
        super.setDisplay(display);

    }
}
