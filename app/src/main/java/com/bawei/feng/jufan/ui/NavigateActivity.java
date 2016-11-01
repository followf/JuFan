package com.bawei.feng.jufan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.feng.jufan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航页面
 */
public class NavigateActivity extends BaseActivity {

    private ViewPager vp;
    private List<View> list;
    private int[] images={R.mipmap.v1,R.mipmap.v2,R.mipmap.v3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        SharedPreferences sp = getSharedPreferences("openFirst", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", false);
        if(isFirst){
            startActivity(new Intent(NavigateActivity.this,LoginActivity.class));
            finish();
        }


        initData();
        initView();
    }

    private void initData() {

        list=new ArrayList<View>();

      for (int i=0;i<images.length;i++){
          View v=View.inflate(this,R.layout.vp_na_item,null);

            v.setBackgroundResource(images[i]);

            list.add(v);
          if(i==2){
              v.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      SharedPreferences sp = getSharedPreferences("openFirst", MODE_PRIVATE);
                      SharedPreferences.Editor edit = sp.edit();
                      edit.putBoolean("isFirst",true);
                      edit.commit();

                      startActivity(new Intent(NavigateActivity.this,LoginActivity.class));
                      finish();
                  }
              });
          }


      }


    }

    private void initView() {

        vp= (ViewPager) findViewById(R.id.vp_na);

        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(list.get(position));

                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });


    }
}
