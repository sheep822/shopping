package com.sheep.mylibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment<P> extends Fragment {
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        presenter = getPresenter();
        initView(view);
        initData();
        return view;
    }

    protected abstract P getPresenter();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();
}
