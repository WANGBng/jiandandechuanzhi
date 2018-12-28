package com.bwie.wang.my1228.my.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.bwie.wang.my1228.R;
import com.bwie.wang.my1228.mvp.presenter.InfoPresenter;
import com.bwie.wang.my1228.mvp.view.HomeView;
import com.bwie.wang.my1228.mvp.view.InfoView;
import com.bwie.wang.my1228.my.adapter.HomeAdapter;
import com.bwie.wang.my1228.my.bean.HomeBean;
import com.bwie.wang.my1228.my.bean.Xiangqing;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoActivity extends AppCompatActivity implements InfoView {

    @BindView(R.id.info_simple)
    SimpleDraweeView infoSimple;
    @BindView(R.id.flyBanner)
    ViewPager flyBanner;
    @BindView(R.id.txt_subhead)
    TextView txtSubhead;
    @BindView(R.id.txt_fe)
    TextView txtFe;
    @BindView(R.id.txt_fen)
    TextView txtFen;
    @BindView(R.id.txt_pric)
    TextView txtPric;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_salenu)
    TextView txtSalenu;
    @BindView(R.id.txt_salenum)
    TextView txtSalenum;
    Unbinder unbinder;
    InfoPresenter infoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        unbinder = ButterKnife.bind(this);
        infoPresenter= new InfoPresenter();
        infoPresenter.attachView(this);
        infoPresenter.loadData(1);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(Xiangqing xiangqing) {
        txtSubhead.setText(xiangqing.getData().getTitle());
    }

    @Override
    public void onError(String msg) {

    }
}
