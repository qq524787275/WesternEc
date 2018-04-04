package com.wethis.westernec;


import com.wethis.module_base.base.BaseActivity;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_main.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    public BaseFragment setRootFragment() {
        return MainFragment.newInstance();
    }
}
