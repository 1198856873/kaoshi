package com.example.lenovo.h1705a_mvp2.net;

/**
* Created by TMVPHelper on 2017/11/28
*/
public class NetPresenter extends NetContract.Presenter{

    @Override
    public void getDataFromModel(String url) {
        baseModel.getDataFromNet(url, new CallBacks() {
            @Override
            public void succ(String result) {
                baseView.Show(result);
            }
        });
    }
}