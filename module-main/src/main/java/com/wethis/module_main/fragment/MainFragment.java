package com.wethis.module_main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.widget.bottom.BottomBar;
import com.wethis.module_base.widget.bottom.BottomBarTab;
import com.wethis.module_home.HomeFragment;
import com.wethis.module_main.R;
import com.wethis.module_main.R2;
import com.wethis.module_mine.MineFragment;
import com.wethis.module_shopcar.ShopCarFragment;
import com.wethis.module_shopclass.ShopClassFragment;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
public class MainFragment extends BaseFragment {
    public static final int HOME = 0;
    public static final int SHOPCLASS = 1;
    public static final int SHOPCAR = 2;
    public static final int MINE = 3;
    @BindView(R2.id.bottomBar)
    BottomBar mBottomBar;
    private BaseFragment[] mBaseFragments = new BaseFragment[4];

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        BaseFragment firstFragment = findChildFragment(HomeFragment.class);
        if (firstFragment == null) {
            mBaseFragments[HOME] = HomeFragment.newInstance();
            mBaseFragments[SHOPCLASS] = ShopClassFragment.newInstance();
            mBaseFragments[SHOPCAR] = ShopCarFragment.newInstance();
            mBaseFragments[MINE] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.delegate_containe, HOME, mBaseFragments[HOME]
                    , mBaseFragments[SHOPCLASS], mBaseFragments[SHOPCAR]
                    , mBaseFragments[MINE]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mBaseFragments[HOME] = firstFragment;
            mBaseFragments[SHOPCLASS] = findChildFragment(ShopClassFragment.class);
            mBaseFragments[SHOPCAR] = findChildFragment(ShopCarFragment.class);
            mBaseFragments[MINE] = findChildFragment(MineFragment.class);
        }
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_home_normal, "首页"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_car_normal, "分类"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_shopcar_normal, "购物车"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_mine_normal, "我的"));
        mBottomBar.getItem(SHOPCAR).setUnreadCount(9);

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideAnimaFragment(mBaseFragments[position], mBaseFragments[prePosition], getFragmentManager());
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    //

}
