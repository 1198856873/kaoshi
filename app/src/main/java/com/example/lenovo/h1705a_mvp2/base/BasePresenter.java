package com.example.lenovo.h1705a_mvp2.base;

/**
 * Created by lenovo on 2017/11/28.
 */
public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;
    public void setVM(M m,V v){
        baseModel=m;
        baseView=v;
        this.onStart();
    }

    public abstract void onStart();
}
