package com.example.myjd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.myjd.bean.HomeBean;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.example.myjd.view.activity.GoodsXiangQingActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/14$ 17:31$
 */
public class MyTuiJian2Adapter extends RecyclerView.Adapter<MyTuiJian2Adapter.ViewHolder2> implements View.OnClickListener {
    Context context;
    List<HomeBean.TuijianBean.ListBean> list;

    public MyTuiJian2Adapter(Context context, List<HomeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_tuijian_1,null);
        ViewHolder2 viewHolder2 = new ViewHolder2(view);
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, final int position) {
        String[] split = list.get(position).getImages().split("[|]");
        Phoenix.with(holder.iv1).load(split[0]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GoodsXiangQingActivity.class);
                intent.putExtra("url",list.get(position).getDetailUrl());
                context.startActivity(intent);
            }
        });
        holder.tv_xiangsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(context,"正在寻找,请耐心等待到花开的季节！");
            }
        });
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_price.setText("￥:"+list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder2 extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv1;
        public TextView tv_price;
        public TextView tv_title;
        public TextView tv_xiangsi;
        public ViewHolder2(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.item_tjsdv);
            tv_xiangsi = itemView.findViewById(R.id.tv_kanxiangsi);
            tv_price = itemView.findViewById(R.id.item_tjtv_price);
            tv_title = itemView.findViewById(R.id.item_tjtv_title);
        }
    }
}
