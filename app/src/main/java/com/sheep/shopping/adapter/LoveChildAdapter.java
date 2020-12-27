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

import java.util.ArrayList;

public class LoveChildAdapter extends RecyclerView.Adapter<LoveChildAdapter.HomeHolder> {

    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;
    private Context context;

    public LoveChildAdapter(ArrayList<HomeBean.DataDTO.TopicListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_love_chlid,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv1.setText(list.get(position).getTitle());
        holder.tv2.setText("￥"+list.get(position).getPrice_info()+"元起");
        holder.tv3.setText(list.get(position).getSubtitle());
        Glide.with(context).load(list.get(position).getItem_pic_url()).into(holder.iv);
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

            iv=itemView.findViewById(R.id.iv_love_chlid);
            tv1=itemView.findViewById(R.id.tv_love_chlid_title);
            tv2=itemView.findViewById(R.id.tv_love_chlid_price);
            tv3=itemView.findViewById(R.id.tv_love_chlid_newtitle);
        }
    }
}
