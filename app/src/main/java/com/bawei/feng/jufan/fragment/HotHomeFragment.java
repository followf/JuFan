package com.bawei.feng.jufan.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.feng.jufan.R;
import com.bawei.feng.jufan.adapter.HotLvAdapter;
import com.bawei.feng.jufan.adapter.HotVpAdapter;
import com.bawei.feng.jufan.bean.HotPageBean;
import com.bawei.feng.jufan.tools.Urls;
import com.bawei.feng.jufan.view.MyListView;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class HotHomeFragment extends Fragment {
    private List<HotPageBean.ContentBean.BannerBean> banner;
    private List<HotPageBean.ContentBean.ListBean> listBeen;
    private ViewPager mVp;
    private LinearLayout mRg;
    private MyListView mLv;

    private List<ImageView> radioButtons;


    Handler handler = new Handler() {


        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 0) {
                String json = (String) msg.obj;
                Gson gson = new Gson();
                HotPageBean hotPageBean = gson.fromJson(json, HotPageBean.class);
                banner = hotPageBean.getContent().getBanner();
                listBeen = hotPageBean.getContent().getList();

                mVpSetAdapter();
                mLvSetAdapter();
            } else if (msg.what == 1) {
                int i = mVp.getCurrentItem();
                mVp.setCurrentItem(++i);
                handler.sendEmptyMessageDelayed(1, 4000);
            }
        }


    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_home_hot, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        getData();
    }

    private void initView() {

        mVp = (ViewPager) getView().findViewById(R.id.vp_hotf);
        mRg = (LinearLayout) getView().findViewById(R.id.rg_hotf);
        mLv = (MyListView) getView().findViewById(R.id.lv_hotf);
    }

    private void addDots() {
        radioButtons = new ArrayList<ImageView>();
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mParams.setMargins(5, 0, 5, 0);

        for (int i = 0; i < banner.size(); i++) {
            // RadioButton rb=new RadioButton(getActivity());
            ImageView rb = new ImageView(getActivity());
            rb.setLayoutParams(mParams);

            rb.setImageResource(R.drawable.hot_rbt);

            if (i == 0) {
                rb.setSelected(true);
            }
            mRg.addView(rb);
            radioButtons.add(rb);

        }

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < radioButtons.size(); i++) {
                    if (position % banner.size() == i) {
                        radioButtons.get(i).setSelected(true);
                    } else {
                        radioButtons.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void mVpSetAdapter() {
        mVp.setAdapter(new HotVpAdapter(getActivity(), banner));
        addDots();
        mVp.setCurrentItem(10000 / 2 - 5000 % banner.size());
        handler.sendEmptyMessageDelayed(1, 4000);
    }

    private void mLvSetAdapter() {
    mLv.setAdapter(new HotLvAdapter(getActivity(),listBeen));
    }


    private void getData() {

        OkHttpUtils.get().url(Urls.HOT).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Call call, String s) {

                Message msg = new Message();
                msg.obj = s;
                msg.what = 0;
                handler.sendMessage(msg);
                Log.e("===============", s);
            }
        });
    }


}
