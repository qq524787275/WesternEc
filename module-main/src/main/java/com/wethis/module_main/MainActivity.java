package com.wethis.module_main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wethis.module_base.base.BaseActivity;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_main.fragment.MainFragment;

import me.yokeyword.fragmentation.anim.FragmentAnimator;

@Route(path = "/main/index")
public class MainActivity extends BaseActivity {

    @Override
    public BaseFragment setRootFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new FragmentAnimator(R.anim.a_fragment_enter,R.anim.a_fragment_exit,R.anim.a_fragment_pop_enter,R.anim.a_fragment_pop_exit);
    }
}
