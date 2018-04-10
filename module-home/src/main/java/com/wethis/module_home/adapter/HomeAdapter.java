package com.wethis.module_home.adapter;

import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.util.Util;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.wethis.module_base.App;
import com.wethis.module_base.Constants;
import com.wethis.module_base.GlideImageLoader;
import com.wethis.module_base.utils.BitmapUtils;
import com.wethis.module_base.widget.banner.Banner;
import com.wethis.module_base.widget.banner.BannerConfig;
import com.wethis.module_home.HomeFragment;
import com.wethis.module_home.R;
import com.wethis.module_home.bean.IndexBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zzc on 2017/11/6/006.
 */

public class HomeAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private HomeFragment homeFragment;

    public HomeAdapter(HomeFragment homeFragment) {
        super(new ArrayList<MultiItemEntity>());
        this.homeFragment = homeFragment;
        addItemType(IndexBean.BANNER, R.layout.home_multi_item_banner);
        addItemType(IndexBean.NAVIGATION, R.layout.home_multi_item_navigation);
        addItemType(IndexBean.HOT, R.layout.home_multi_item_hot);
        addItemType(IndexBean.SHOPLIST, R.layout.home_multi_item_shoplist);
        addItemType(IndexBean.SHOPSTORE, R.layout.home_multi_item_shopstore);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case IndexBean.BANNER:
                IndexBean.PlatAdvListBean platAdvListBean = (IndexBean.PlatAdvListBean) item;
                final Banner banner = helper.getView(R.id.multi_item_banner);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setImageLoader(new GlideImageLoader());
                banner.setDelayTime(3000);
                final List<String> list = new ArrayList<>();
                list.add(Constants.TRANSITION_URLS[0]);
                list.add(Constants.TRANSITION_URLS[2]);
                list.add(Constants.TRANSITION_URLS[5]);
                list.add(Constants.TRANSITION_URLS[3]);
//                for (int i = 0; i < platAdvListBean.getAdv_list().size(); i++) {
//                    list.add(platAdvListBean.getAdv_list().get(i).getAdv_image());
//                }
                banner.setImages(list);
                banner.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        if (Util.isOnMainThread()) {
                            Glide.with(App.getContent()).load(list.get(position)).asBitmap().into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    changeTopBgColor(resource);
                                }
                            });
                        }
                    }
                });
                banner.start();
                break;
            case IndexBean.NAVIGATION:
//                RecyclerView navigationRv = helper.getView(R.id.multi_item_navigation_rv);
//                GridLayoutManager layout = new GridLayoutManager(mContext, 5);
//                navigationRv.setLayoutManager(layout);
//                List<String> strings = new ArrayList<>();
//                for (int i = 0; i < 10; i++) {
//                    strings.add(i + "");
//                }
//                navigationRv.setAdapter(new NavigationAdapter(strings));
                break;
            case IndexBean.HOT:
//                UPMarqueeView upMarqueeView = helper.getView(R.id.multi_item_hot_marquee);
//                List<View> hotlist = new ArrayList<>();
//                for (int i = 0; i < 5; i++) {
//                    View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_marquee, upMarqueeView, false);
//                    hotlist.add(inflate);
//                }
//                upMarqueeView.setViews(hotlist);
                break;
            case IndexBean.SHOPLIST:
                IndexBean.BlockListBean blockListBean = (IndexBean.BlockListBean) item;
                helper.setText(R.id.multi_item_shoplist_title, blockListBean.getCategory_name());

                RecyclerView shoplist = helper.getView(R.id.multi_item_shoplist_rv);
                shoplist.setLayoutManager(new GridLayoutManager(mContext, 2));
                final GoodsListAdapter goodsAdapter = new GoodsListAdapter();

                if (blockListBean.getGoods_list() != null)
                    goodsAdapter.addData(blockListBean.getGoods_list());

                goodsAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                    }
                });
                helper.getView(R.id.multi_item_shoplist_title_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                goodsAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                        switch (view.getId()) {
//                            case R.id.item_shop_list_shopcar:
//                                homeFragment.getGoodsDetail(goodsAdapter.getData().get(position).getGoods_id());
//                            break;
//                            default:
//                                break;
//                        }
                    }
                });
                shoplist.setAdapter(goodsAdapter);
                break;
            case IndexBean.SHOPSTORE:
                RecyclerView shopstore = helper.getView(R.id.multi_item_shopstore_rv);
                helper.addOnClickListener(R.id.multi_item_shopstore_layout_title);
                shopstore.setLayoutManager(new LinearLayoutManager(mContext));
                List<String> listStore = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    listStore.add(i + "");
                }
                shopstore.setAdapter(new ShopStoreAdapter(listStore));
                break;
            default:
                break;
        }
    }

    private void changeTopBgColor(Bitmap bitmap) {

        if (bitmap == null)
            return;
        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //获取到充满活力的这种色调
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                //根据调色板Palette获取到图片中的颜色设置到toolbar和tab中背景，标题等，使整个UI界面颜色统一
                homeFragment.setThemeColor(BitmapUtils.colorBurn(vibrant.getRgb()));
//                if (android.os.Build.VERSION.SDK_INT >= 21 && vibrant!=null) {
//                    Window window = homeFragment.getActivity().getWindow();
//                    window.setStatusBarColor(BitmapUtils.colorBurn(vibrant.getRgb()));
//                    window.setNavigationBarColor(BitmapUtils.colorBurn(vibrant.getRgb()));
//                }
            }
        });
    }


}
