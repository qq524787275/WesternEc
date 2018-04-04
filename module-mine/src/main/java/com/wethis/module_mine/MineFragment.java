package com.wethis.module_mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wethis.module_base.base.BaseFragment;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
public class MineFragment extends BaseFragment {
    public static MineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
