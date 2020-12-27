package com.sheep.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.sheep.shopping.R;
import com.sheep.shopping.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends DelegateAdapter.Adapter<HomeAdapter.HomeHolder> {
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> list;
    private Context context;

    public HomeAdapter(SingleLayoutHelper singleLayoutHelper, ArrayList<HomeBean.DataDTO.CategoryListDTO> list, Context context) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        HomeBean.DataDTO.CategoryListDTO dto = list.get(position);
        List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = dto.getGoodsList();
        holder.rel.setLayoutManager(new GridLayoutManager(context,2));
        HomeChildAdapter homeChildAdapter = new HomeChildAdapter(goodsList, context);
        holder.rel.setAdapter(homeChildAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private RecyclerView rel;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            rel = itemView.findViewById(R.id.rel_home2);
            tv=itemView.findViewById(R.id.tv_home_title);
        }
    }


}
