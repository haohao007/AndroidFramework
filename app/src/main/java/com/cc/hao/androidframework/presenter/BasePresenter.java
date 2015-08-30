package com.cc.hao.androidframework.presenter;


import com.cc.hao.androidframework.ui.display.Display;
import com.google.common.base.Preconditions;

/**
 * Created by hao on 2015/8/15.
 */
abstract class BasePresenter implements Presenter {
    private Display mDisplay;
    private Boolean mInited;

    public final void init(){
        Preconditions.checkState(mInited==false,"already inited");
        mInited=true;
        onInited();
    }

    public final void suspend(){
        Preconditions.checkState(mInited==true,"has not inited");
        onSuspend();
        mInited=false;
    }

    protected void onInited(){};
    protected void onSuspend(){};

    public boolean isInited(){
        return mInited;
    }

    protected Display getDisplay(){
        return mDisplay;
    }

    protected void setDisplay(Display display){
        this.mDisplay=display;
    }

    public final void assertInited(){
        Preconditions.checkState(mInited,"must be inited when running");
    }

    public void attachDisplay(Display display) {
        Preconditions.checkNotNull(display, "display is null");
        Preconditions.checkState(getDisplay() == null, "we currently have a display");
        setDisplay(display);
    }

    public void detachDisplay(Display display) {
        Preconditions.checkNotNull(display, "display is null");
        Preconditions.checkState(getDisplay() == display, "display is not attached");
        setDisplay(null);
    }
}
