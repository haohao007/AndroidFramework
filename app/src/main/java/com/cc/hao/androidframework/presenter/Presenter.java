package com.cc.hao.androidframework.presenter;


import com.cc.hao.androidframework.ui.display.Display;

/**
 * Created by hao on 2015/8/18.
 */
public interface Presenter {

    public void init();

    public void suspend();

    public void assertInited();

    public void attachDisplay(Display display);

    public void detachDisplay(Display display);
}
