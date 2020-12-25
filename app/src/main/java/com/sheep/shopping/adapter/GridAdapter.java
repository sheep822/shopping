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

public class GridAdapter extends DelegateAdapter.Adapter<GridAdapter.HomeHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> list;
    private Context context;

    public GridAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataDTO.ChannelDTO> list, Context context) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gird, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        Glide.with(context).load(list.get(position).getIcon_url()).into(holder.iv);
        holder.tv.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);

            iv=itemView.findViewById(R.id.iv_grid);
            tv=itemView.findViewById(R.id.tv_grid);
        }
    }
}
