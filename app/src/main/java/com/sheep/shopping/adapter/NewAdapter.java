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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewAdapter extends DelegateAdapter.Adapter<NewAdapter.HomeHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> list;
    private Context context;

    public NewAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataDTO.NewGoodsListDTO> list, Context context) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        holder.tv_price.setText("￥"+list.get(position).getRetail_price());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView iv;
        private TextView tv_price;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_new);
            iv = itemView.findViewById(R.id.iv_new);
            tv_price=itemView.findViewById(R.id.tv_price);
        }
    }
}
