package com.sheep.shopping.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.sheep.mylibrary.utils.net.URLConstant;
import com.sheep.shopping.R;
import com.sheep.shopping.adapter.BannerAdapter;
import com.sheep.shopping.base.BaseFragment;
import com.sheep.shopping.bean.HomeBean;
import com.sheep.shopping.contract.MyContract;
import com.sheep.shopping.presenter.ImpPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment<ImpPresenter> implements MyContract.InView<HomeBean> {


    private RecyclerView rel_home;
    private TextView tv_search;
    private ImageView iv_search;
    private ArrayList<HomeBean.DataDTO.BannerDTO> bannerDTOS;
    private Banner banner;
    private VirtualLayoutManager virtualLayoutManager;
    private ArrayList<HomeBean.DataDTO.BannerDTO> bannerlist;
    private BannerAdapter bannerAdapter;


    @Override
    protected ImpPresenter getPresenter() {
        return new ImpPresenter(this);
    }

    @Override
    protected void initData() {
        presenter.getData(URLConstant.HomeLIST);
    }

    protected void initView(View view) {
        rel_home = view.findViewById(R.id.rel_home);
        tv_search = view.findViewById(R.id.tv_search);
        iv_search = view.findViewById(R.id.iv_search);
        banner = view.findViewById(R.id.banner);

        bannerlist = new ArrayList<>();

        // 初始化有一个布局管理器
        virtualLayoutManager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rel_home.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);

        initBanner();
    }

    private void initBanner() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        bannerAdapter = new BannerAdapter(singleLayoutHelper, bannerlist, getActivity());


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(bannerAdapter);

        rel_home.setLayoutManager(virtualLayoutManager);
        rel_home.setAdapter(delegateAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        /*bannerDTOS = new ArrayList<>();
        bannerDTOS.addAll(homeBean.getData().getBanner());
        banner.setImages(bannerDTOS)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataDTO path1 = (HomeBean.DataDTO) path;
                        Glide.with(getActivity()).load(path1.getBanner()).into(imageView);
                    }
                }).start();*/
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG", "onFail: " + error);
    }



}