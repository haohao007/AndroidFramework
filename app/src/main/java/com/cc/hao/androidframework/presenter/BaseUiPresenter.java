package com.cc.hao.androidframework.presenter;


import com.cc.hao.androidframework.state.BaseState;
import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import de.greenrobot.event.EventBus;

/**
 * Created by hao on 2015/8/15.
 */
public abstract class BaseUiPresenter<U extends BaseUiPresenter.Ui<UC>,UC> extends BasePresenter{
    public interface Ui<UC>{
        void setCallback(UC callback);
        //可扩展
    }

    private final Set<U> mUis;
    private final Set<U> mUnmodifiableUis;

    public BaseUiPresenter(){
        mUis=new CopyOnWriteArraySet<U>();
        mUnmodifiableUis= Collections.unmodifiableSet(mUis);
    }

    protected final Set<U> getUis() {
        return mUnmodifiableUis;
    }

    protected void onInited() {
        if (!mUis.isEmpty()) {
            for (U ui : mUis) {
                onUiAttached(ui);
                populateUi(ui);
            }
        }
    }

    //第一次绑定UI
    public synchronized final void attachUi(U ui){
        //注册订阅事件
        EventBus.getDefault().register(this);

        Preconditions.checkArgument(ui!=null,"UI can not be null");
        Preconditions.checkState(mUis.contains(ui),"UI is already attached");
        mUis.add(ui);
        ui.setCallback(createUiCallbacks(ui));
        if (isInited()){
            onUiAttached(ui);
            populateUi(ui);
        }


    }

    protected abstract UC createUiCallbacks(U ui);

    //绑定UI之后
    protected void onUiAttached(U ui) {

    }
    //填充UI事件
    protected void populateUi(U ui) {}

    //解绑UI
    public synchronized final void detachUi(U ui) {
        //注销订阅事件
        EventBus.getDefault().unregister(this);

        Preconditions.checkArgument(ui != null, "ui cannot be null");
        Preconditions.checkState(mUis.contains(ui), "ui is not attached");
        onUiDetached(ui);
        ui.setCallback(null);
        mUis.remove(ui);
    }

    protected void onUiDetached(U ui) {}

    //通过哈希码查询绑定的UI
    protected synchronized U findUi(final int id) {
        for (U ui : mUis) {
            if (getId(ui) == id) {
                return ui;
            }
        }
        return null;
    }
    public int getId(U ui) {
        return ui.hashCode();
    }

    //事件接收者
    public void onEvent(BaseState.UiEvent event) {
        Preconditions.checkNotNull(event, "event cannot be null");
        final U ui=findUi(event.UiCode);
        if (ui != null) {
            //回调事件处理
            populateUi(ui);
        }else{
            handleEvent(event);
        }
    }

    //特殊事件处理
    protected void handleEvent(BaseState.UiEvent event){}



}
