package com.example.myjd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.View;
import android.view.ViewGroup;

import com.example.myjd.bean.HomeBean;
import com.example.myjd.view.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/14$ 17:31$
 */
public class MyTuiJian0Adapter extends RecyclerView.Adapter<MyTuiJian0Adapter.ViewHolder2> {
    Context context;
    List<HomeBean.TuijianBean.ListBean> list;
    private final int TYPE_ONE=1;


    public MyTuiJian0Adapter(Context context, List<HomeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_tuijian1,null);
        ViewHolder2 viewHolder2 = new ViewHolder2(view);
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        String[] split = list.get(position).getImages().split("[|]");
        if (split.length>1){
            Phoenix.with(holder.iv1).load(split[0]);
            Phoenix.with(holder.iv2).load(split[1]);
        }else {
            Phoenix.with(holder.iv1).load(split[0]);
            Phoenix.with(holder.iv2).load(split[0]);
        }
    }

    @Override
    public int getItemCount() {
        return list.size()/3;
    }


    class ViewHolder2 extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv1;
        public SimpleDraweeView iv2;
        public ViewHolder2(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.tuijian_sdv1);
            iv2 = itemView.findViewById(R.id.tuijian_sdv2);
        }
    }
}
