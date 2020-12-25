package com.sheep.shopping.view.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sheep.shopping.R;
import com.sheep.shopping.view.fragment.FenFragment;
import com.sheep.shopping.view.fragment.HomeFragment;
import com.sheep.shopping.view.fragment.MyFragment;
import com.sheep.shopping.view.fragment.ShoppingFragment;
import com.sheep.shopping.view.fragment.ZhuanFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup rg;
    private RadioButton rtHomePage;
    private RadioButton rtZhuan;
    private RadioButton rtFen;
    private RadioButton rtShop;
    private RadioButton rtMy;
    private FrameLayout frame;

    private FragmentTransaction transaction;

    private ArrayList<Fragment> fragments;
    private FragmentManager fm;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rtHomePage = (RadioButton) findViewById(R.id.rt_homePage);
        rtZhuan = (RadioButton) findViewById(R.id.rt_zhuan);
        rtFen = (RadioButton) findViewById(R.id.rt_fen);
        rtShop = (RadioButton) findViewById(R.id.rt_shop);
        rtMy = (RadioButton) findViewById(R.id.rt_my);
        frame = (FrameLayout) findViewById(R.id.frame);

        rg.setOnCheckedChangeListener(this);

        fragments = getFragments(); //添加布局
        //添加默认布局
        normalFragment();

    }

    private void normalFragment() {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        fragment = fragments.get(0);
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ZhuanFragment());
        fragments.add(new FenFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new MyFragment());
        return fragments;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        switch (checkedId) {
            case R.id.rt_homePage:
                fragment = fragments.get(0);
                transaction.replace(R.id.frame, fragment);
                break;
            case R.id.rt_zhuan:
                fragment = fragments.get(1);
                transaction.replace(R.id.frame, fragment);
                break;
            case R.id.rt_fen:
                fragment = fragments.get(2);
                transaction.replace(R.id.frame, fragment);
                break;
            case R.id.rt_shop:
                fragment = fragments.get(3);
                transaction.replace(R.id.frame, fragment);
                break;
            case R.id.rt_my:
                fragment = fragments.get(4);
                transaction.replace(R.id.frame, fragment);
                break;
        }

        transaction.commit();
    }

}