package com.example.lenovo.h1705a_mvp2.net;


import com.example.lenovo.h1705a_mvp2.app.App;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
* Created by TMVPHelper on 2017/11/28
*/
public class NetModel implements NetContract.Model{
    public static  NetModel netModel;
    private OkHttpClient okHttpClient;

    public static NetModel getInstance() {
        if (netModel == null) {
            synchronized (NetModel.class) {
                netModel = new NetModel();
            }
        }
        return netModel;
    }

    public NetModel()    {
        okHttpClient = new OkHttpClient();
    }
    @Override
    public void getDataFromNet(String url, final CallBacks callBacks) {
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String ss=response.body().string();

                App.mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.succ(ss);
                    }
                });

            }
        });

    }
}