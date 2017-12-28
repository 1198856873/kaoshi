package com.example.lenovo.h1705a_mvp2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.h1705a_mvp2.utils.TUtils;


public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {
    public P presenter;
    public M model;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = TUtils.getT(this, 0);
        model = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            presenter.setVM(model,this);
        }
        view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract int getLayoutId() ;
}

