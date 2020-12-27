package com.sheep.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.sheep.shopping.R;
import com.sheep.shopping.bean.HomeBean;

import java.util.ArrayList;

public class SleepAdapter extends DelegateAdapter.Adapter<SleepAdapter.HomeHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> list;
    private Context context;

    public SleepAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataDTO.HotGoodsListDTO> list, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sleep, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText(list.get(position).getGoods_brief());
        holder.tv3.setText("￥"+list.get(position).getRetail_price());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_sleep);
            tv1 = itemView.findViewById(R.id.tv_title);
            tv2 = itemView.findViewById(R.id.tv_name);
            tv3 = itemView.findViewById(R.id.tv_sleep_price);
        }
    }
}
