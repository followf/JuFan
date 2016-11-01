package com.bawei.feng.jufan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.feng.jufan.R;
import com.bawei.feng.jufan.adapter.HomeVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页界面
 * Created by Administrator on 2016/10/28 0028.
 */
public class HomeFragment extends Fragment{

    private ViewPager vp;
    private TabLayout tabLayout;


    private List<Fragment> list;
    private String[] titles={"关注","热门","最新"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_home,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        inttData();
        initView();




    }

    private void inttData() {
        list=new ArrayList<>();
        AttHomeFragment attHomeFragment=new AttHomeFragment();
        HotHomeFragment hotHomeFragment =new HotHomeFragment();
        LastHomeFragment lastHomeFragment =new LastHomeFragment();


        list.add(attHomeFragment);
        list.add(hotHomeFragment);
        list.add(lastHomeFragment);



    }

    private void initView() {

        tabLayout = (TabLayout) getView().findViewById(R.id.tl);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

//        tab.addTab(tab.newTab().setText(titles[0]));
//        tab.addTab(tab.newTab().setText(titles[1]));
//        tab.addTab(tab.newTab().setText(titles[2]));



        vp= (ViewPager) getView().findViewById(R.id.vp_home);
        vp.setAdapter(new HomeVpAdapter(getActivity().getSupportFragmentManager(),list));
        vp.setCurrentItem(1);
        tabLayout.setupWithViewPager(vp);





    }
}
