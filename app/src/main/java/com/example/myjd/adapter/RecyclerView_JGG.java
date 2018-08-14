package com.example.myjd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.myjd.bean.JGGDaoHangBean;
import com.example.myjd.view.R;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/13$ 20:09$
 */
public class RecyclerView_JGG extends RecyclerView.Adapter<RecyclerView_JGG.ViewHolder> implements View.OnClickListener {
    Context context;
    List<JGGDaoHangBean.DataBean> list;
    int mIndex;
    int mPageSize;
    onItemClickListener onItemClickListener;

    public RecyclerView_JGG(Context context,List<JGGDaoHangBean.DataBean> list, int mIndex, RecyclerView_JGG.onItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.mIndex = mIndex;
        this.onItemClickListener = onItemClickListener;
        mPageSize = 5*2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_grideview,null);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = position+mIndex*mPageSize;
        holder.itemView.setTag(pos);
        Glide.with(context).load(list.get(pos).getIcon()).into(holder.iv);
        holder.tv.setText(list.get(pos).getName());
    }
    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(v, (Integer) v.getTag());
    }

    public interface onItemClickListener{
        void onItemClick(View view,int position);
    }
    @Override
    public int getItemCount() {
        return list.size()>(mIndex+1)*mPageSize?mPageSize:(list.size()-mIndex*mPageSize);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
       public TextView tv;
       public ImageView iv;
       public ViewHolder(View itemView) {
           super(itemView);
           tv = itemView.findViewById(R.id.tv_gride_title);
           iv = itemView.findViewById(R.id.iv_grid_img);
       }
   }
}
