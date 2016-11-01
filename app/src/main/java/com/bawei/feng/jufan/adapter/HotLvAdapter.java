package com.bawei.feng.jufan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bawei.feng.jufan.R;
import com.bawei.feng.jufan.bean.HotPageBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class HotLvAdapter extends BaseAdapter {
    private Context context;
    private List<HotPageBean.ContentBean.ListBean> listBeen;

    public HotLvAdapter(Context context, List<HotPageBean.ContentBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.lv_hotf_item, null);
            holder.sdvBig = (SimpleDraweeView) convertView.findViewById(R.id.sdv_big_lv_item);
            holder.sdvSmall = (SimpleDraweeView) convertView.findViewById(R.id.sdv_small_lv_item);

            holder.tvName = (TextView) convertView.findViewById(R.id.tvname_lv_item);
            holder.tvPosi = (TextView) convertView.findViewById(R.id.tvlocation_lv_item);
            holder.tvLive= (TextView) convertView.findViewById(R.id.tvLive);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.sdvBig.setImageURI(listBeen.get(position).getMidheadimg());
        holder.sdvSmall.setImageURI(listBeen.get(position).getSmallheadimg());
        holder.tvName.setText(listBeen.get(position).getName());
        holder.tvPosi.setText(listBeen.get(position).getPlace());
        holder.tvLive.setText("LIVE  "+listBeen.get(position).getOnline());
        return convertView;
    }

    class ViewHolder {
        private TextView tvName, tvPosi,tvLive;
        private SimpleDraweeView sdvBig, sdvSmall;


    }


}
