package com.wethis.module_shopcar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wethis.module_base.base.BaseFragment;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
public class ShopCarFragment extends BaseFragment {
    public static ShopCarFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShopCarFragment fragment = new ShopCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_shopcar;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
    }
}
