package com.wethis.module_home.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wethis.module_home.R;
import com.wethis.module_home.bean.IndexBean;

import java.util.ArrayList;

/**
 * 作者: Zzc on 2017-12-18.
 * 版本: v1.0
 */

public class GoodsListAdapter extends BaseQuickAdapter<IndexBean.BlockListBean.GoodsListBean,BaseViewHolder> {
    public GoodsListAdapter() {
        super(R.layout.home_item_shop_list,new ArrayList<IndexBean.BlockListBean.GoodsListBean>());
    }

    @Override
    protected void convert(BaseViewHolder helper, IndexBean.BlockListBean.GoodsListBean item) {
        String price = item.getPromotion_price();
        if(price==null)
            return;
        helper.setText(R.id.item_shop_list_title,item.getGoods_name())
                .setText(R.id.item_shop_list_price,"¥"+ price);
        Glide.with(mContext).
                load(item.getPic_cover_mid()).
                crossFade(500).
                placeholder(R.mipmap.img_one_bi_one).
                error(R.mipmap.img_one_bi_one).
                into((ImageView) helper.getView(R.id.item_shop_list_image));
//        Glide.with(mContext).load(item.getPic_cover_mid()).placeholder(R.mipmap.logo).into((ImageView) helper.getView(R.id.item_shop_list_image));
        helper.addOnClickListener(R.id.item_shop_list_shopcar);
    }
}
