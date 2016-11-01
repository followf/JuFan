package com.bawei.feng.jufan.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class ToastUtils {

    public static void showToast(Context context,String str){

        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();

    }

}
