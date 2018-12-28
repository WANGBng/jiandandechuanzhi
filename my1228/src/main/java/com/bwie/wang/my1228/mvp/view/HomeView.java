package com.bwie.wang.my1228.mvp.view;

import com.bwie.wang.my1228.base.BaseView;
import com.bwie.wang.my1228.my.bean.HomeBean;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public interface HomeView extends BaseView {

    void onSuccess(HomeBean.DataBean homeBean);
    void onError(String msg);

}
