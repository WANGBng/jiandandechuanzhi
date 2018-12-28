package com.bwie.wang.my1228.mvp.presenter;

import com.bwie.wang.my1228.base.BasePresenter;
import com.bwie.wang.my1228.mvp.model.HomeModel;
import com.bwie.wang.my1228.mvp.view.HomeView;
import com.bwie.wang.my1228.my.bean.HomeBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public class HomePresenter extends BasePresenter<HomeView> {
    private final HomeModel homeModel;

    public HomePresenter() {
        homeModel = new HomeModel();
    }

    public void loadData(){
        homeModel.getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        HomeBean.DataBean data = homeBean.getData();
                        getView().onSuccess(data);
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
