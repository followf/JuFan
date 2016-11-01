package com.bawei.feng.jufan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.feng.jufan.ui.BaseActivity;
import com.bawei.feng.jufan.ui.NavigateActivity;


public class AppStartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);


        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(4000);
                    startActivity(new Intent(AppStartActivity.this, NavigateActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
