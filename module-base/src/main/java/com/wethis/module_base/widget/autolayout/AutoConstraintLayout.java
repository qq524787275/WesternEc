package com.wethis.module_base.widget.autolayout;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.wethis.module_base.widget.autolayout.utils.AutoLayoutHelper;

/**
 * 作者: Zzc on 2018-04-09.
 * 版本: v1.0
 */

public class AutoConstraintLayout extends ConstraintLayout {

    private AutoLayoutHelper mHelper = new AutoLayoutHelper(this);

    public AutoConstraintLayout(Context context) {
        super(context);
    }

    public AutoConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        if (!isInEditMode())
            mHelper.adjustChildren();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
    }


    public static class LayoutParams extends ConstraintLayout.LayoutParams
            implements AutoLayoutHelper.AutoLayoutParams
    {
        private AutoLayoutInfo mAutoLayoutInfo;

        public LayoutParams(Context c, AttributeSet attrs)
        {
            super(c, attrs);
            mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs);
        }

        public LayoutParams(int width, int height)
        {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source)
        {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source)
        {
            super(source);
        }

        @Override
        public AutoLayoutInfo getAutoLayoutInfo()
        {
            return mAutoLayoutInfo;
        }


    }


}
