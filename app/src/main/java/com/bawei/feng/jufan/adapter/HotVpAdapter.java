package com.bawei.feng.jufan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.feng.jufan.R;
import com.bawei.feng.jufan.bean.HotPageBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class HotVpAdapter extends PagerAdapter{
    private Context context;
    private  List<HotPageBean.ContentBean.BannerBean> banner;

    public HotVpAdapter(Context context, List<HotPageBean.ContentBean.BannerBean> banner) {
        this.context = context;
        this.banner = banner;
    }

    @Override
    public int getCount() {
        return 10000;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v=View.inflate(context, R.layout.vp_hotf_item,null);
        SimpleDraweeView sdv= (SimpleDraweeView) v.findViewById(R.id.sdv_vp_item);

        sdv.setImageURI(banner.get(position%banner.size()).getImg());

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
