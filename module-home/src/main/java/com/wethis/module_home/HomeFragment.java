package com.wethis.module_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.kennyc.view.MultiStateView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wethis.module_base.Constants;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.callback.BaseResponse;
import com.wethis.module_base.callback.JsonCallback;
import com.wethis.module_base.widget.progressing.SpinKitDialog;
import com.wethis.module_base.widget.progressing.Style;
import com.wethis.module_home.adapter.HomeAdapter;
import com.wethis.module_home.bean.IndexBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */

public class HomeFragment extends BaseFragment {

    @BindView(R2.id.home_rv)
    RecyclerView homeRv;
    @BindView(R2.id.smartrefreshlayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R2.id.fab)
    FloatingActionButton mFab;
    @BindView(R2.id.home_stateview)
    MultiStateView mStateView;
    @BindView(R2.id.home_ns)
    NestedScrollView mNestedView;
    private HomeAdapter adapter;
    private SpinKitDialog mLoadingDialg;
    private LinearLayoutManager linearLayoutManager;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mLoadingDialg = new SpinKitDialog.Builder(_mActivity)
                .setColor(ContextCompat.getColor(_mActivity, R.color.red_ff5354))
                .setStyle(Style.CUBE_GRID)
                .setTextColor(ContextCompat.getColor(_mActivity, R.color.red_ff5354))
                .builder();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mNestedView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY - oldScrollY > 5) {
                    mFab.hide();
                } else if (scrollY - oldScrollY < -5) {
                    mFab.show();
                }
            }
        });


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNestedView.scrollTo(0,0);
//                mNestedView.scrollToPositionWithOffset(0, 0);
            }
        });

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                index();
            }
        });
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        linearLayoutManager = new LinearLayoutManager(_mActivity);
        homeRv.setLayoutManager(linearLayoutManager);
        adapter = new HomeAdapter(this);
        homeRv.setAdapter(adapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        index();
    }

    public void index() {
        mLoadingDialg.show();
        OkGo.<BaseResponse<IndexBean>>post(Constants.URL_INDEX)
                .tag(this)
                .execute(new JsonCallback<BaseResponse<IndexBean>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<IndexBean>> response) {
                        IndexBean result = response.body().result;
                        if (result == null)
                            return;
                        List<MultiItemEntity> list = new ArrayList<>();
                        list.add(result.getPlat_adv_list());
                        List<IndexBean.BlockListBean> block_list = result.getBlock_list();
                        if (block_list != null) {
                            for (int i = 0; i < block_list.size(); i++) {
                                list.add(block_list.get(i));
                            }
                        }
                        adapter.setNewData(list);
                        mStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                    }

                    @Override
                    public void onError(Response<BaseResponse<IndexBean>> response) {
                        super.onError(response);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoadingDialg.dismiss();
                        smartRefreshLayout.finishRefresh();
                    }
                });
    }

    public void setThemeColor(int colorPrimary) {
        if (smartRefreshLayout != null)
            smartRefreshLayout.setPrimaryColors(colorPrimary, ContextCompat.getColor(_mActivity, R.color.white));
    }
}
