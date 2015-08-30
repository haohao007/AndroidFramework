package com.cc.hao.androidframework.presenter;

import javax.inject.Singleton;

/**
 * Created by hao on 2015/8/19.
 */
@Singleton
public class UserPresenter extends BaseUiPresenter<UserPresenter.UserUi,
        UserPresenter.UserUiCallbacks> {

    public interface UserUi extends BaseUiPresenter.Ui<UserUiCallbacks> {}

    public interface UserUiCallbacks {}


    @Override
    protected UserUiCallbacks createUiCallbacks(final UserUi ui) {
        return new UserUiCallbacks() {

        };
    }

    public UserPresenter(){

    }

    @Override
    protected void onInited() {
        super.onInited();

    }

    @Override
    protected void onSuspend() {
        super.onSuspend();
    }
}
