package com.bawei.feng.jufan.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.feng.jufan.R;
import com.bawei.feng.jufan.fragment.HomeFragment;
import com.bawei.feng.jufan.fragment.MineFragment;
import com.bawei.feng.jufan.tools.ToastUtils;

public class MainActivity extends BaseActivity {

    private HomeFragment mHomeFragment;
    private MineFragment mMineFragment;
    private FragmentManager supportFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();


    }

    private void initFragment() {
        mHomeFragment=new HomeFragment();
        mMineFragment=new MineFragment();

        supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction().add(R.id.fl_main,mHomeFragment).add(R.id.fl_main,mMineFragment)
                .show(mHomeFragment).hide(mMineFragment).commit();


    }


    public void showHome(View v) {
        supportFragmentManager.beginTransaction()
                .show(mHomeFragment).hide(mMineFragment).commit();
    }

    public void showMe(View v) {
        supportFragmentManager.beginTransaction()
                .hide(mHomeFragment).show(mMineFragment).commit();
    }

    public void myShow(View v) {
        ToastUtils.showToast(this,"点我直播");
    }
}
