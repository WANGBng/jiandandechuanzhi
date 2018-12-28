package com.bwie.wang.my1228.mvp.view;

import android.graphics.Paint;

import com.bwie.wang.my1228.base.BaseView;
import com.bwie.wang.my1228.my.bean.Xiangqing;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public interface InfoView extends BaseView{
    void onSuccess(Xiangqing xiangqing);
    void onError(String msg);

}
