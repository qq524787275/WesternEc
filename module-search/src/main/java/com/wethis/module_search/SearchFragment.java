package com.wethis.module_search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.QMUIFloatLayout;
import com.sdsmdg.tastytoast.TastyToast;
import com.wethis.module_base.base.BaseFragment;
import com.wethis.module_base.widget.view.SearchBar;

import butterknife.BindView;

/**
 * 作者: Zzc on 2018-04-03.
 * 版本: v1.0
 */
@Route(path = "/search/index")
public class SearchFragment extends BaseFragment {
    @BindView(R2.id.searchbar)
    SearchBar searchbar;
    @BindView(R2.id.search_fl_hot)
    QMUIFloatLayout searchFlHot;
    @BindView(R2.id.search_fl_hostory)
    QMUIFloatLayout searchFlHostory;
    public static SearchFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Object setLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        initSearchBar();
    }

    private void initSearchBar() {
        searchbar.setSearchType(SearchBar.SearchType.SEARCH)
                .setOnSearchClickListener(new SearchBar.OnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        if(TextUtils.isEmpty(keyword)){
                            TastyToast.makeText(_mActivity.getApplicationContext(),"关键字不能为空",TastyToast.LENGTH_SHORT,TastyToast.ERROR);
                            Toast.makeText(_mActivity, "关键字不能为空", Toast.LENGTH_SHORT).show();
                            return;
                        }
//                        MainFragment.getMainFragment().extraTransaction().startDontHideSelf(ShopListFragment.newInstance(keyword));
                        hideSoftInput();
                    }
                })
                .setOnLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop();
                    }
                });
        showSoftInput(searchbar.getSearchEdittext());
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < 10; i++) {
            LayoutInflater.from(_mActivity).inflate(R.layout.view_label, searchFlHot, true);
        }

        for (int i = 0; i < 20; i++) {
            LayoutInflater.from(_mActivity).inflate(R.layout.view_label, searchFlHostory, true);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideSoftInput();
    }
}
