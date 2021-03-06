package com.sheep.shopping.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.sheep.mylibrary.utils.net.URLConstant;
import com.sheep.shopping.R;
import com.sheep.shopping.adapter.BannerAdapter;
import com.sheep.shopping.adapter.GridAdapter;
import com.sheep.shopping.adapter.HomeAdapter;
import com.sheep.shopping.adapter.LoveAdapter;
import com.sheep.shopping.adapter.MakeAdapter;
import com.sheep.shopping.adapter.NewAdapter;
import com.sheep.shopping.adapter.SleepAdapter;
import com.sheep.shopping.adapter.Text1Adapter;
import com.sheep.shopping.adapter.Text2Adapter;
import com.sheep.shopping.adapter.Text3Adapter;
import com.sheep.shopping.adapter.Text4Adapter;
import com.sheep.shopping.base.BaseFragment;
import com.sheep.shopping.bean.HomeBean;
import com.sheep.shopping.contract.MyContract;
import com.sheep.shopping.presenter.ImpPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<ImpPresenter> implements MyContract.InView<HomeBean> {


    private RecyclerView rel_home;
    private TextView tv_search;
    private ImageView iv_search;
    private ArrayList<HomeBean.DataDTO.BannerDTO> bannerDTOS;
    private Banner banner;
    private VirtualLayoutManager virtualLayoutManager;
    private BannerAdapter bannerAdapter;

    private GridAdapter gridAdapter;
    private ArrayList<HomeBean.DataDTO.BannerDTO> bannerlist;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> girdlist;
    private DelegateAdapter delegateAdapter;
    private Text1Adapter text1Adapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> makelist;
    private MakeAdapter makeAdapter;
    private Text2Adapter text2Adapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newlist;
    private NewAdapter newAdapter;
    private Text3Adapter text3Adapter;
    private SleepAdapter sleepAdapter;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> slppelist;
    private Text4Adapter text4Adapter;
    private LoveAdapter loveAdapter;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> lovelist;
    private HomeAdapter homeAdapter;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> homelist;


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
        girdlist = new ArrayList<>();
        makelist = new ArrayList<>();
        newlist = new ArrayList<>();
        slppelist = new ArrayList<>();
        lovelist = new ArrayList<>();
        homelist = new ArrayList<>();

        // 初始化有一个布局管理器
        virtualLayoutManager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rel_home.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);

        initBanner();
        initGird();
        initText1();
        initMake();
        initText2();
        initNew();
        initText3();
        initSleep();
        initText4();
        initLove();
        initHome();
    }

    private void initHome() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        homeAdapter = new HomeAdapter(singleLayoutHelper,homelist,getActivity());


        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(text1Adapter);
        delegateAdapter.addAdapter(makeAdapter);
        delegateAdapter.addAdapter(text2Adapter);
        delegateAdapter.addAdapter(newAdapter);
        delegateAdapter.addAdapter(text3Adapter);
        delegateAdapter.addAdapter(sleepAdapter);
        delegateAdapter.addAdapter(text4Adapter);
        delegateAdapter.addAdapter(loveAdapter);
        delegateAdapter.addAdapter(homeAdapter);

        rel_home.setLayoutManager(virtualLayoutManager);
        rel_home.setAdapter(delegateAdapter);
    }

    private void initLove() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        loveAdapter = new LoveAdapter(singleLayoutHelper,lovelist,getActivity());
    }

    private void initText4() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        text4Adapter = new Text4Adapter(singleLayoutHelper, getActivity());
    }

    private void initSleep() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(3);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        gridLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{100});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(1);// 设置每行多少个网格

        sleepAdapter = new SleepAdapter(gridLayoutHelper, slppelist, getActivity());


    }

    private void initText3() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        text3Adapter = new Text3Adapter(singleLayoutHelper, getActivity());
    }

    private void initNew() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        gridLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格

        newAdapter = new NewAdapter(gridLayoutHelper, newlist, getActivity());
    }

    private void initText2() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        text2Adapter = new Text2Adapter(singleLayoutHelper, getActivity());
    }

    private void initMake() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(2);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(10);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(10);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格

        makeAdapter = new MakeAdapter(gridLayoutHelper, makelist, getActivity());
    }

    private void initGird() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格

        gridAdapter = new GridAdapter(gridLayoutHelper, girdlist, getActivity());

    }

    private void initText1() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(6);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比

        text1Adapter = new Text1Adapter(singleLayoutHelper, getActivity());
    }


    private void initBanner() {
        //  设置通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        /*singleLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离*/
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        bannerAdapter = new BannerAdapter(singleLayoutHelper, bannerlist, getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        List<HomeBean.DataDTO.BannerDTO> banner = homeBean.getData().getBanner();
        bannerlist.addAll(banner);
        bannerAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.ChannelDTO> grid = homeBean.getData().getChannel();
        girdlist.addAll(grid);
        gridAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.BrandListDTO> make = homeBean.getData().getBrandList();
        makelist.addAll(make);
        makeAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.NewGoodsListDTO> good = homeBean.getData().getNewGoodsList();
        newlist.addAll(good);
        newAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.HotGoodsListDTO> sleep = homeBean.getData().getHotGoodsList();
        slppelist.addAll(sleep);
        sleepAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.TopicListDTO> love = homeBean.getData().getTopicList();
        lovelist.addAll(love);
        loveAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.CategoryListDTO> home = homeBean.getData().getCategoryList();
        homelist.addAll(home);
        homeAdapter.notifyDataSetChanged();
    }


    @Override
    public void onFail(String error) {
        Log.e("TAG", "onFail: " + error);
    }


}