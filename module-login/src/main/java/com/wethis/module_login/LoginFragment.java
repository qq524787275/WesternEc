package com.wethis.module_login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wethis.module_base.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

@Route(path = "/login/index")
public class LoginFragment extends BaseFragment {
    @BindView(R2.id.img)
    ImageView imageView;
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
//        ViewCompat.setTransitionName(imageView,"share");
    }
}
