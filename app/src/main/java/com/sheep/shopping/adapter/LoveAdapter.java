package com.sheep.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.sheep.shopping.R;
import com.sheep.shopping.bean.HomeBean;

import java.util.ArrayList;

public class LoveAdapter extends DelegateAdapter.Adapter<LoveAdapter.HomeHolder> {
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;
    private Context context;

    public LoveAdapter(SingleLayoutHelper singleLayoutHelper, ArrayList<HomeBean.DataDTO.TopicListDTO> list, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_love, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rel.setLayoutManager(linearLayoutManager);
        LoveChildAdapter loveChildAdapter = new LoveChildAdapter(list, context);
        holder.rel.setAdapter(loveChildAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomeHolder extends RecyclerView.ViewHolder {

        private RecyclerView rel;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            rel = itemView.findViewById(R.id.rel_love);
        }
    }


}
