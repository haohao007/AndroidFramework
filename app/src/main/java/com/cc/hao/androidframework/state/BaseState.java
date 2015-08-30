package com.cc.hao.androidframework.state;

/**
 * Created by hao on 2015/8/16.
 */
public class BaseState {

    public static class UiEvent{
        public final int UiCode;
        public UiEvent(int UiCode){
            this.UiCode=UiCode;
        }
    }

}
