package com.wethis.module_base.widget.classics;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.wethis.module_base.R;

/**
 * 作者: Zzc on 2017-12-22.
 * 版本: v1.0
 */

public class CustomHeader extends RelativeLayout implements RefreshHeader {
    private static final String TAG = "CustomHeader";
    private LottieAnimationView mLoadingView;
    public CustomHeader(Context context) {
        this(context, null);
    }

    public CustomHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.custom_header,this);
        mLoadingView=findViewById(R.id.custom_header_loading);
    }

    //不用管
    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
        mLoadingView.setVisibility(VISIBLE);
        if(offset<mLoadingView.getHeight()) {
            mLoadingView.setProgress((float) offset / mLoadingView.getHeight());
        }

    }

    //不用管
    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
        if(offset<mLoadingView.getHeight()) {
            mLoadingView.setProgress((float) offset / mLoadingView.getHeight());
        }
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return null;
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {
           mLoadingView.pauseAnimation();
        mLoadingView.setProgress(0);
    }

    //不用管
    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {
        mLoadingView.loop(true);
        mLoadingView.playAnimation();
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mLoadingView.loop(false);
        mLoadingView.pauseAnimation();
        mLoadingView.setProgress(1.0f);
        return 0;
    }

    //不用管
    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
                Log.i(TAG, "onStateChanged: None");
            case PullDownToRefresh:
                Log.i(TAG, "onStateChanged: PullDownToRefresh");
                break;
            case Refreshing:
                Log.i(TAG, "onStateChanged: Refreshing");
                break;
            case ReleaseToRefresh:

                Log.i(TAG, "onStateChanged: ReleaseToRefresh");
                break;
            case Loading:
                Log.i(TAG, "onStateChanged: Loading");
                break;
        }
    }
}
