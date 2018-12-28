package com.bwie.wang.my1228.mvp.presenter;

import com.bwie.wang.my1228.base.BasePresenter;
import com.bwie.wang.my1228.mvp.view.InfoView;
import com.bwie.wang.my1228.my.bean.Xiangqing;
import com.bwie.wang.my1228.my.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public class InfoPresenter extends BasePresenter<InfoView> {

    public void loadData(int pid) {
        HttpUtils.getInstance().api.queryGoodsByPid(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Xiangqing>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Xiangqing xiangqing) {
                        getView().onSuccess(xiangqing);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}