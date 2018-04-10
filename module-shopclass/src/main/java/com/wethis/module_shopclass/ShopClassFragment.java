package com.wethis.module_shopclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.wethis.module_base.Constants;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.callback.BaseResponse;
import com.wethis.module_base.callback.JsonCallback;
import com.wethis.module_base.widget.progressing.SpinKitDialog;
import com.wethis.module_base.widget.progressing.Style;
import com.wethis.module_base.widget.view.SearchBar;
import com.wethis.module_shopclass.adapter.CategoryLeftAdapter;
import com.wethis.module_shopclass.bean.CategoryBean;
import com.wethis.module_shopclass.fragment.CategoryRightFragment;

import java.util.List;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
public class ShopClassFragment extends BaseFragment {
    @BindView(R2.id.searchbar)
    SearchBar mSearchBar;
    @BindView(R2.id.shopclass_list)
    RecyclerView mRvList;
    @BindView(R2.id.category_refresh)
    SwipeRefreshLayout categoryRefresh;

    private CategoryLeftAdapter mLeftAdapter;
    private SpinKitDialog mLoadingDialg;

    public static ShopClassFragment newInstance() {

        Bundle args = new Bundle();

        ShopClassFragment fragment = new ShopClassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_shopclass;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        initSearchBar();
        mRvList.setLayoutManager(new LinearLayoutManager(_mActivity));
        mLeftAdapter = new CategoryLeftAdapter();
        mRvList.setAdapter(mLeftAdapter);

        categoryRefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(_mActivity,R.color.bg_all));
        categoryRefresh.setColorSchemeColors(ContextCompat.getColor(_mActivity,R.color.red_ff5354));

        mLoadingDialg = new SpinKitDialog.Builder(_mActivity)
                .setColor(ContextCompat.getColor(_mActivity,R.color.red_ff5354))
                .setStyle(Style.CUBE_GRID)
                .setTextColor(ContextCompat.getColor(_mActivity,R.color.red_ff5354))
                .builder();
    }

    private void initSearchBar() {
        mSearchBar.setSearchType(SearchBar.SearchType.NOSEARCH)
                .setOnNoSearClickListener(new SearchBar.OnNoSearchClickListener() {
                    @Override
                    public void OnNoSearchClick() {
                        BaseFragment searchFragment= (BaseFragment) ARouter.getInstance().build("/search/index").navigation();
                        ((BaseFragment) getParentFragment()).
                                start(searchFragment);
                    }
                })
                .setOnLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new QMUIDialog.MessageDialogBuilder(_mActivity)
                                .setTitle("友情提示")
                                .setMessage("确定要退出吗?")
                                .addAction("取消", new QMUIDialogAction.ActionListener() {
                                    @Override
                                    public void onClick(QMUIDialog dialog, int index) {
                                        dialog.dismiss();
                                    }
                                })
                                .addAction(0, "确认", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                                    @Override
                                    public void onClick(QMUIDialog dialog, int index) {
                                        dialog.dismiss();
                                        _mActivity.finish();
                                    }
                                }).show();
                    }
                });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mLeftAdapter.setCurrent(position);
                showContent(position);
            }
        });

        categoryRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getGoodsCategoryTree(0);
            }
        });
    }

    private void showContent(int position) {
        CategoryRightFragment categoryRightFragment = CategoryRightFragment.newInstance(mLeftAdapter.getData().get(position));
        BaseFragment contentFragment = findChildFragment(CategoryRightFragment.class);
        if (contentFragment != null) {
            contentFragment.replaceFragment(categoryRightFragment, false);
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        getGoodsCategoryTree(0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }

    public void getGoodsCategoryTree(int pid) {
        mLoadingDialg.show();
        OkGo.<BaseResponse<List<CategoryBean>>>post(Constants.URL_GETGOODSCATEGORYTREE)
                .params("pid", pid)
                .tag(this)
                .execute(new JsonCallback<BaseResponse<List<CategoryBean>>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<List<CategoryBean>>> response) {
//                        mStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                        if (response.body().result.size() == 0)
                            return;
                        mLeftAdapter.setCurrent(0);
                        mLeftAdapter.setNewData(response.body().result);
                        loadRootFragment(R.id.shopclass_content, CategoryRightFragment.newInstance(response.body().result.get(0)), false, false);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoadingDialg.dismiss();
                        categoryRefresh.setRefreshing(false);
                    }
                });
    }
}
