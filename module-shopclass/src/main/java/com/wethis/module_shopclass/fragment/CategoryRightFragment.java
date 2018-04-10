package com.wethis.module_shopclass.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_shopclass.R;
import com.wethis.module_shopclass.R2;
import com.wethis.module_shopclass.adapter.CategoryRightAdapter;
import com.wethis.module_shopclass.bean.CategoryBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by Zzc on 2017/11/2/002.
 */

public class CategoryRightFragment extends BaseFragment {

    @BindView(R2.id.category_right_rv)
    RecyclerView categoryRightRv;
    private CategoryRightAdapter adapter;
    private CategoryBean categoryBean;

    public static CategoryRightFragment newInstance(CategoryBean categoryBean) {

        Bundle args = new Bundle();
        args.putParcelable("CategoryBean", categoryBean);
        CategoryRightFragment fragment = new CategoryRightFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.shopcalss_fragment_category_right;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        categoryBean = getArguments().getParcelable("CategoryBean");
        final GridLayoutManager manager = new GridLayoutManager(_mActivity, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == CategoryRightAdapter.TYPE_LEVEL_1 ? 1 : manager.getSpanCount();
            }
        });

        List<CategoryBean.ChildListBeanX> child_list = categoryBean.getChild_list();
        List<MultiItemEntity> list=new ArrayList<>();

        for (int i = 0; i < child_list.size(); i++) {
            CategoryBean.ChildListBeanX e = child_list.get(i);
            list.add(e);
            if(e.getChild_list()==null)return;
            for (int j = 0; j < e.getChild_list().size(); j++) {
                list.add(e.getChild_list().get(j));
            }
        }

        adapter = new CategoryRightAdapter(list,this);
        categoryRightRv.setAdapter(adapter);
        categoryRightRv.setLayoutManager(manager);
        }

    @Override
    protected void initEvent() {
        super.initEvent();
//        adapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onNoDoubleItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ((MainFragment)getParentFragment().getParentFragment()).startBrotherFragment(ShopListFragment.newInstance(categoryBean.getChild_list().get(position).getCategory_id()));
//            }
//        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }
}
