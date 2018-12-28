package com.bwie.wang.my1228.my.utils;

import com.bwie.wang.my1228.my.bean.HomeBean;
import com.bwie.wang.my1228.my.bean.Xiangqing;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public interface Api {
    @GET("home/getHome")
    Observable<HomeBean> shouye();
    @GET("product/getProductDetail")
    Observable<Xiangqing> queryGoodsByPid(@Query("pid") int pid);
}
