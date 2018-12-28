package com.bwie.wang.my1228.my.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwie.wang.my1228.R;
import com.bwie.wang.my1228.mvp.presenter.HomePresenter;
import com.bwie.wang.my1228.mvp.view.HomeView;
import com.bwie.wang.my1228.my.adapter.HomeAdapter;
import com.bwie.wang.my1228.my.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity  implements HomeView {

    @BindView(R.id.rec_home)
    RecyclerView recHome;
    Unbinder unbinder;
    HomePresenter homePresenter;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.loadData();
    }


    @Override
    public void onSuccess(HomeBean.DataBean homeBean) {
        final List<HomeBean.DataBean.TuijianBean.ListBeanX> list = homeBean.getTuijian().getList();
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recHome.setLayoutManager(gridLayoutManager);
        homeAdapter = new HomeAdapter(this,list);
        recHome.setAdapter(homeAdapter);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        homePresenter.detachView();
    }

}
