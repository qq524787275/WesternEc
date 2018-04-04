package com.wethis.module_splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wethis.module_base.base.BaseFragment;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

public class SplashFragment extends BaseFragment {
    public static SplashFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SplashFragment fragment = new SplashFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_splash;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
