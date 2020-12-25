package com.sheep.shopping.model;

import com.sheep.mylibrary.utils.net.NetCallBack;
import com.sheep.mylibrary.utils.net.RetrofitUtils;
import com.sheep.shopping.contract.MyContract;

public class ImpModel<T> implements MyContract.InModel<T>  {
    @Override
    public void getData(String url, NetCallBack<T> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(url, callBack);
    }
}
