package com.cc.hao.androidframework;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PresenterHandler implements InvocationHandler{

    private Object target;

    public PresenterHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //某类函数作统一特殊处理

        Object object=method.invoke(target,args);
        return object;
    }

}
