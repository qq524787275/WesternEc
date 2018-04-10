package com.wethis.module_splash;

import android.view.KeyEvent;

import com.wethis.module_base.base.BaseActivity;
import com.wethis.module_base.base.BaseFragment;

public class MainActivity extends BaseActivity {

    @Override
    public BaseFragment setRootFragment() {
        return SplashFragment.newInstance();
    }

    //重新返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }
}
