package com.example.lenovo.h1705a_mvp2.net;


import com.example.lenovo.h1705a_mvp2.base.BaseModel;
import com.example.lenovo.h1705a_mvp2.base.BasePresenter;
import com.example.lenovo.h1705a_mvp2.base.BaseView;

/**
 * Created by lenovo on 2017/11/28.
 */
public class NetContract  {

    public interface View extends BaseView {
      void Show(String ss);


    }

    interface Model extends BaseModel {
        void getDataFromNet(String url, CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void getDataFromModel(String url);
    }
}