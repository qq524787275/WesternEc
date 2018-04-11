package com.wethis.module_shopdetail;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wethis.module_base.base.BaseActivity;
import com.wethis.module_base.base.BaseFragment;

import butterknife.BindView;

@Route(path = "/shopdetail/index")
public class MainActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @Autowired
    int goods_id;
    @Autowired
    String goods_name;
    @Autowired
    String promotion_price;
    @Override
    public BaseFragment setRootFragment() {
        ARouter.getInstance().inject(this);
        return ShopDetailFragment.newInstance(goods_id,goods_name,promotion_price);
    }
}
