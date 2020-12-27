package com.sheep.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.sheep.shopping.R;

public class Text3Adapter extends DelegateAdapter.Adapter<Text3Adapter.HomeHolder> {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;

    public Text3Adapter(SingleLayoutHelper singleLayoutHelper, Context context) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text1, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv.setText("人气推荐");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv1);
        }
    }


}
