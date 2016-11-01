package com.bawei.feng.jufan.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.feng.jufan.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void loginWX(View v) {
        gotoMain();
    }

    public void loginQQ(View v) {
        gotoMain();
    }

    public void loginPH(View v) {
        gotoMain();
    }

    public void loginWB(View v) {
        gotoMain();
    }


    private void gotoMain(){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }

}
