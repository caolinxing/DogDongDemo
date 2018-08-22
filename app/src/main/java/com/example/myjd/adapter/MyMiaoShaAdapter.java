package com.example.myjd.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myjd.bean.HomeBean;
import com.example.myjd.utils.CountDownUtils;
import com.example.myjd.utils.ToastUtils;
import com.example.myjd.view.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/14$ 17:31$
 */
public class MyMiaoShaAdapter extends RecyclerView.Adapter {
    Context context;
    List<HomeBean.MiaoshaBean.ListBeanX> list;
    private final int TYPE_ONE=1;
    private final int TYPE_TWO=2;


    public MyMiaoShaAdapter(Context context, List<HomeBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_ONE){
            View view = View.inflate(context,R.layout.item_miaosha1,null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }else {
            View view = View.inflate(context,R.layout.item_miaosha2,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder1){
            ViewHolder1 holder1 = (ViewHolder1) holder;
            long expires = 1546300800;
            long current = System.currentTimeMillis()/1000;
            if (expires < current) {
                holder1.item_miaosha1_tv_timer.setText("活动已结束");
            } else {
                new CountDownUtils(expires - current, holder1.item_miaosha1_tv_timer).startCount();
            }
            Phoenix.with(holder1.iv1).load(list.get(position).getImages().split("[|]")[0]);
            Phoenix.with(holder1.iv2).load(list.get(position).getImages().split("[|]")[1]);
            Phoenix.with(holder1.iv3).load(list.get(position).getImages().split("[|]")[2]);
            holder1.tv_barginprice1.setText("￥:"+list.get(position).getBargainPrice());
            holder1.tv_barginprice2.setText("￥:"+list.get(position).getBargainPrice());
            holder1.tv_barginprice3.setText("￥:"+list.get(position).getBargainPrice());
            holder1.tv_price1.setText("￥:"+list.get(position).getPrice());
            holder1.tv_price2.setText("￥:"+list.get(position).getPrice());
            holder1.tv_price3.setText("￥:"+list.get(position).getPrice());
            holder1.tv_barginprice1.setPaintFlags(holder1.tv_barginprice1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder1.tv_barginprice2.setPaintFlags(holder1.tv_barginprice2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder1.tv_barginprice3.setPaintFlags(holder1.tv_barginprice3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(context,"点击了条目类型1");
                }
            });
        }else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Phoenix.with(holder2.iv1).load(list.get(position).getImages().split("[|]")[0]);
            Phoenix.with(holder2.iv2).load(list.get(position).getImages().split("[|]")[1]);
            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(context,"点击了条目类型"+position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    class ViewHolder1 extends RecyclerView.ViewHolder{
        public TextView tv_barginprice1;
        public TextView item_miaosha1_tv_timer;
        public TextView tv_barginprice2;
        public TextView tv_barginprice3;
        public TextView tv_price1;
        public TextView tv_price2;
        public TextView tv_price3;
        public SimpleDraweeView iv1;
        public SimpleDraweeView iv2;
        public SimpleDraweeView iv3;
        public ViewHolder1(View itemView) {
            super(itemView);
            tv_barginprice1 = itemView.findViewById(R.id.item_miaosha1_barginprice1);
            item_miaosha1_tv_timer = itemView.findViewById(R.id.item_miaosha1_tv_timer);
            tv_price1 = itemView.findViewById(R.id.item_miaosha1_price1);
            tv_barginprice2 = itemView.findViewById(R.id.item_miaosha1_barginprice2);
            tv_price2 = itemView.findViewById(R.id.item_miaosha1_price2);
            tv_barginprice3 = itemView.findViewById(R.id.item_miaosha1_barginprice3);
            tv_price3 = itemView.findViewById(R.id.item_miaosha1_price3);
            iv1 = itemView.findViewById(R.id.item_miaosha1_sdv1);
            iv2 = itemView.findViewById(R.id.item_miaosha1_sdv2);
            iv3 = itemView.findViewById(R.id.item_miaosha1_sdv3);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv1;
        public SimpleDraweeView iv2;
        public ViewHolder2(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.item_miaosha2_sdv1);
            iv2 = itemView.findViewById(R.id.item_miaosha2_sdv2);
        }
    }
}
