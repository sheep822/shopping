package com.sheep.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sheep.shopping.R;
import com.sheep.shopping.bean.HomeBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeChildAdapter extends RecyclerView.Adapter<HomeChildAdapter.HomeHolder> {
    private List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> list;
    private Context context;

    public HomeChildAdapter(List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home2, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        holder.tv_price.setText(list.get(position).getRetail_price());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv_price;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_home2_child);
            tv = itemView.findViewById(R.id.tv_home2_child);
            tv_price=itemView.findViewById(R.id.tv_home2_child_price);
        }
    }
}
