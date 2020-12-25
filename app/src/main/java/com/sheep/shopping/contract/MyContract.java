package com.sheep.shopping.contract;

import com.sheep.mylibrary.utils.net.NetCallBack;

public class MyContract {

    public interface InModel<B> {
        void getData(String url, NetCallBack<B> callBack);
    }

    public interface InPresenter{
        void getData(String url);
    }

    public interface InView<T> {
        void onSuccess(T t);

        void onFail(String error);
    }
}
