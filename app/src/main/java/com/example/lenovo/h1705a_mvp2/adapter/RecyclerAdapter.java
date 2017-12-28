package com.example.lenovo.h1705a_mvp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.h1705a_mvp2.R;
import com.example.lenovo.h1705a_mvp2.bean.MyBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/26.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private  List<MyBean.DataBean> mList;
    private Context context;

    public RecyclerAdapter(List<MyBean.DataBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        ViewHolder holder=new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mText.setText(mList.get(position).getTitle().toString());
        Glide.with(context).load(mList.get(position).getThumb()).into(holder.mImage);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImage;
        public ViewHolder(View itemView) {
            super(itemView);
            mText= (TextView) itemView.findViewById(R.id.Text);
            mImage= (ImageView) itemView.findViewById(R.id.Image);
        }
    }
}
