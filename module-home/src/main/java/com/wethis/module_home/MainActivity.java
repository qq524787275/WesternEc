package com.wethis.module_home;


import com.wethis.module_base.base.BaseActivity;
import com.wethis.module_base.base.BaseFragment;

public class MainActivity extends BaseActivity {

    @Override
    public BaseFragment setRootFragment() {
        return HomeFragment.newInstance();
    }
}
