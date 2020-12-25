package com.sheep.mylibrary.utils.net;

import java.util.HashMap;

public interface NetWorkInterface {
    public <B> void get(String url, NetCallBack<B> callBack);

    public <B> void post(String url, NetCallBack<B> callBack);

    public <B> void postPar(String url, HashMap<String,String> map, NetCallBack<B> callBack);
}
