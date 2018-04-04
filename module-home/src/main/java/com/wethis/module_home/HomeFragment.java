package com.wethis.module_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.kennyc.view.MultiStateView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sdsmdg.tastytoast.TastyToast;
import com.wethis.module_base.Constants;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.callback.BaseResponse;
import com.wethis.module_base.callback.JsonCallback;
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
//    private HomeAdapter adapter;
    private QMUITipDialog loadingDialog;
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

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        homeRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 5) {
                    mFab.hide();
                } else if (dy < -5) {
                    mFab.show();
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutManager.scrollToPositionWithOffset(0, 0);
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
//        adapter = new HomeAdapter(this);
//        homeRv.setAdapter(adapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        index();
    }

    public void index() {
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
//                        adapter.setNewData(list);
                        TastyToast.makeText(_mActivity.getApplicationContext(),"刷新成功~",TastyToast.LENGTH_SHORT,TastyToast.SUCCESS);
                        mStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                    }

                    @Override
                    public void onError(Response<BaseResponse<IndexBean>> response) {
                        super.onError(response);
                        TastyToast.makeText(_mActivity.getApplicationContext(),"刷新失败~",TastyToast.LENGTH_SHORT,TastyToast.ERROR);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        smartRefreshLayout.finishRefresh();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
}
