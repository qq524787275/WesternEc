package com.wethis.module_search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wethis.module_base.base.BaseFragment;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

public class SearchFragment extends BaseFragment {
    public static SearchFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
