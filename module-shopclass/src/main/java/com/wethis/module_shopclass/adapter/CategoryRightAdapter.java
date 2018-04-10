package com.wethis.module_shopclass.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.wethis.module_shopclass.R;
import com.wethis.module_shopclass.bean.CategoryBean;
import com.wethis.module_shopclass.fragment.CategoryRightFragment;

import java.util.List;

/**
 * Created by Zzc on 2017/11/13/013.
 */

public class CategoryRightAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {

    public static final int TYPE_LEVEL_0=0;
    public static final int TYPE_LEVEL_1=1;
    private CategoryRightFragment mFragment;
    public CategoryRightAdapter(List<MultiItemEntity> list,CategoryRightFragment mFragment) {
        super(list);
        addItemType(TYPE_LEVEL_0, R.layout.shopclass_item_category_right_group);
        addItemType(TYPE_LEVEL_1,R.layout.shopclass_item_category_right);
        this.mFragment=mFragment;
    }



    @Override
    protected void convert(final BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_LEVEL_0:
                final CategoryBean.ChildListBeanX beanX = (CategoryBean.ChildListBeanX) item;
                helper.setText(R.id.item_category_right_group_title,beanX.getCategory_name());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        ((MainFragment)mFragment.getParentFragment().getParentFragment()).startBrotherFragment(ShopListFragment.newInstance( beanX.getCategory_id()));
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final CategoryBean.ChildListBeanX.ChildListBean bean = (CategoryBean.ChildListBeanX.ChildListBean) item;
                Glide.with(mContext).
                        load(bean.getCategory_pic()).
                        crossFade(500).
                        placeholder(R.mipmap.img_one_bi_one).
                        error(R.mipmap.img_one_bi_one).
                        into((ImageView) helper.getView(R.id.item_category_right_image));
                 helper.setText(R.id.item_category_right_title,bean.getCategory_name());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        ((BaseFragment)mFragment.getParentFragment().getParentFragment()).start(ShopListFragment.newInstance(bean.getCategory_id()));
                    }
                });
                break;
            default:
                break;
        }
    }


}
