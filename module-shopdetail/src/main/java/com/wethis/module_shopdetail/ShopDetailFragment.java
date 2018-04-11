package com.wethis.module_shopdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.wethis.module_base.Constants;
import com.wethis.module_base.GlideImageLoader;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.callback.BaseResponse;
import com.wethis.module_base.callback.JsonCallback;
import com.wethis.module_base.widget.banner.Banner;
import com.wethis.module_base.widget.banner.BannerConfig;
import com.wethis.module_shopdetail.bean.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-11.
 * 版本: v1.0
 */

public class ShopDetailFragment extends BaseFragment {
    @BindView(R2.id.shopdetail_banner)
    Banner mBanner;
    @BindView(R2.id.shopdetail_goods_name)
    TextView mGoodsName;
    @BindView(R2.id.shopdetail_introduction)
    TextView mIntroduction;
    @BindView(R2.id.shopdetail_promotion_price)
    TextView mPromotinPrice;
    @BindView(R2.id.shopdetail_sales)
    TextView mSales;

    public static ShopDetailFragment newInstance(int goods_id, String goods_name, String promotion_price) {

        Bundle args = new Bundle();
        args.putInt("goods_id", goods_id);
        args.putString("goods_name", goods_name);
        args.putString("promotion_price", promotion_price);
        ShopDetailFragment fragment = new ShopDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_shopdetail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        // 设置自定义元素共享切换动画
        mGoodsName.setText(getArguments().getString("goods_name"));
        mPromotinPrice.setText("¥" + getArguments().getString("promotion_price"));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        getGoodsDetail(getArguments().getInt("goods_id"));
    }

    /**
     * 获取商品详情数据
     *
     * @param goods_id 商品id
     */
    public void getGoodsDetail(int goods_id) {
        OkGo.<BaseResponse<GoodsBean>>post(Constants.URL_GETGOODSDETAIL)
                .tag(this)
                .params("goods_id", goods_id)
                .execute(new JsonCallback<BaseResponse<GoodsBean>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<GoodsBean>> response) {
                        setGoodsData(response.body().result);
                    }
                });
    }


    private void setGoodsData(GoodsBean result) {
        //设置轮播图
        //轮播图
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setImageLoader(new GlideImageLoader());
//        shopDetailBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.setDelayTime(3000);
        List<String> list = new ArrayList<>();
        List<GoodsBean.ImgListBean> img_list = result.getImg_list();
        if (img_list != null) {
            for (int i = 0; i < img_list.size(); i++) {
                GoodsBean.ImgListBean imgListBean = img_list.get(i);
                list.add(imgListBean.getPic_cover_big());
            }
            mBanner.setImages(list);
            mBanner.start();
        }



        mIntroduction.setText(result.getIntroduction());
        mSales.setText("销售量" + result.getSales() + "笔");
    }
}
