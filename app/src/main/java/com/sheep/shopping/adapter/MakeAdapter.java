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

public class MakeAdapter extends DelegateAdapter.Adapter<MakeAdapter.HomeHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> list;
    private Context context;

    public MakeAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataDTO.BrandListDTO> list, Context context) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_make, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_price.setText(list.get(position).getFloor_price());
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private TextView tv_price;
        private TextView tv_name;
        private ImageView iv;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            iv = itemView.findViewById(R.id.iv_make);
        }
    }
}
