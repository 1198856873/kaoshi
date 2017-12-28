package com.example.lenovo.h1705a_mvp2;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.h1705a_mvp2.adapter.RecyclerAdapter;
import com.example.lenovo.h1705a_mvp2.base.BaseActivity;
import com.example.lenovo.h1705a_mvp2.bean.MyBean;
import com.example.lenovo.h1705a_mvp2.net.NetContract;
import com.example.lenovo.h1705a_mvp2.net.NetModel;
import com.example.lenovo.h1705a_mvp2.net.NetPresenter;
import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity<NetPresenter,NetModel> implements NetContract.View,View.OnClickListener {
    private RecyclerView Recycler;
    private  String url="http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=11&controller=content&action=index&page=0&time=0";
    private RecyclerAdapter mAdapter;
    private Button Btn_login,Btn_share,Button_Map;
    private TextView text;
    private ImageView image;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.getDataFromModel(url);
        Recycler= (RecyclerView) findViewById(R.id.Recycler);
        Btn_login= (Button) findViewById(R.id.Button_login);
        Btn_share= (Button) findViewById(R.id.Button_Share);
        Button_Map= (Button) findViewById(R.id.Button_Map);
        text= (TextView) findViewById(R.id.text);
        image= (ImageView) findViewById(R.id.image);
        Btn_login.setOnClickListener(this);
        Btn_share.setOnClickListener(this);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        Recycler.setLayoutManager(llm);
        Button_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivityThree.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void Show(String ss) {
        Gson gson=new Gson();
        MyBean myBean = gson.fromJson(ss, MyBean.class);
        List<MyBean.DataBean> data = myBean.getData();
        mAdapter=new RecyclerAdapter(data,MainActivity.this);
        Recycler.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Button_login:
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
                break;
            case R.id.Button_Share:
                UMImage image = new UMImage(MainActivity.this, R.mipmap.ic_launcher);//网络图片
                new ShareAction(MainActivity.this)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener )
                        .open();
                break;
        }
    }
  //  UMShareAPI.(UserinfoActivity.this).getPlatformInfo(UserinfoActivity.this, SHARE_MEDIA.QQ, umAuthListener);
    //登录内容的监听
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        // 依赖 架包
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

}
