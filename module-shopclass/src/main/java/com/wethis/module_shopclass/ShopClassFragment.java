package com.wethis.module_shopclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wethis.module_base.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
public class ShopClassFragment extends BaseFragment {
    @BindView(R2.id.btn)
    Button button;
    public static ShopClassFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShopClassFragment fragment = new ShopClassFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_shopclass;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseFragment baseFragment= (BaseFragment) ARouter.getInstance().build("/login/index").navigation();
                ((BaseFragment)getParentFragment()). start(baseFragment);
            }
        });
    }
}
