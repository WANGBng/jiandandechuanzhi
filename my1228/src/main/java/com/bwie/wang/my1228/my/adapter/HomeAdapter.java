package com.bwie.wang.my1228.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wang.my1228.R;
import com.bwie.wang.my1228.my.activity.InfoActivity;
import com.bwie.wang.my1228.my.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/28.
 *
 * @author 王丙均
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<HomeBean.DataBean.TuijianBean.ListBeanX> listBeanXES;

    public HomeAdapter(Context context, List<HomeBean.DataBean.TuijianBean.ListBeanX> listBeanXES) {
        this.context = context;
        this.listBeanXES = listBeanXES;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_adapter, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Uri uri = Uri.parse(listBeanXES.get(position).getImages().split("\\|")[0]);
        holder.item_simple.setImageURI(uri);
        holder.title.setText(listBeanXES.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoActivity.class);
                int pid = listBeanXES.get(position).getPid();
                intent.putExtra("pid",pid);
                context.startActivity(intent);
                Toast.makeText(context,"listBeanXES.get(position)"+listBeanXES.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeanXES.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          SimpleDraweeView item_simple;
          TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            item_simple = (SimpleDraweeView) itemView.findViewById(R.id.item_simple);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
