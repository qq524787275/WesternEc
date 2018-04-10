package com.wethis.module_base.base;

import com.sdsmdg.tastytoast.TastyToast;
import com.wethis.module_base.R;


/**
 * 懒加载
 * Created by YoKeyword on 16/6/5.
 */
public abstract class BaseBackFragment extends BaseFragment {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            TastyToast.makeText(_mActivity.getApplicationContext(),getResources().getString(R.string.press_again_exit),TastyToast.LENGTH_SHORT,TastyToast.WARNING);
        }
        return true;
    }
}
