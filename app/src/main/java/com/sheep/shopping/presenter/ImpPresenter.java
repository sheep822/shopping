package com.sheep.shopping.presenter;

import com.sheep.mylibrary.base.BasePresenter;
import com.sheep.mylibrary.utils.net.NetCallBack;
import com.sheep.shopping.bean.HomeBean;
import com.sheep.shopping.contract.MyContract;
import com.sheep.shopping.model.ImpModel;

public class ImpPresenter<T> extends BasePresenter<MyContract.InModel<HomeBean>, MyContract.InView> implements MyContract.InPresenter {
    public ImpPresenter(MyContract.InView<T> view) {
        super(view);
    }


    @Override
    protected MyContract.InModel<HomeBean> getModel() {
        return new ImpModel<HomeBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean bannerBean) {
                view.onSuccess(bannerBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });

    }
}
