package com.wethis.module_base.widget;

import android.view.View;

import com.sdsmdg.tastytoast.TastyToast;

/**
 * Created by Zzc on 2017/11/4/004.
 */

public abstract class OnClickListener implements View.OnClickListener{
    public static Long lastClickTime=0L;
    public static final long minTime=500;
    public abstract void onNoDoubleClick(View view);

    @Override
    public void onClick(View view) {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastClickTime > minTime) {
            lastClickTime = currentTime;
            onNoDoubleClick(view);
            return;
        }
        TastyToast.makeText(view.getContext(),"亲，手速慢点哟~",TastyToast.LENGTH_SHORT,TastyToast.INFO);
      }
}
