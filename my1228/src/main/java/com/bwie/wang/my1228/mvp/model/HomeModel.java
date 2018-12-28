package com.bwie.wang.my1228.mvp.model;

import com.bwie.wang.my1228.my.bean.HomeBean;
import com.bwie.wang.my1228.my.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public class HomeModel {
    public Observable<HomeBean> getHome(){
        Observable<HomeBean> shouye = HttpUtils.getInstance().api.shouye();
        return shouye;
    }
}
