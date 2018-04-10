package com.wethis.module_home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wethis.module_home.R;

import java.util.List;

/**
 * Created by Zzc on 2017/11/7/007.
 */

class ShopStoreAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public ShopStoreAdapter(@Nullable List<String> data) {
        super(R.layout.home_item_shop_store,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
