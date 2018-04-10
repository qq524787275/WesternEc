package com.wethis.module_base.widget.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wethis.module_base.R;

/**
 * 作者: Zzc on 2018-04-08.
 * 版本: v1.0
 */

public class SearchBar extends LinearLayout {
    private ImageView search_left;
    private EditText search_center;
    private LinearLayout search_layout;
    private TextView search_right;
    private OnNoSearchClickListener mOnNoSearchClickListener;
    private OnSearchClickListener mOnSearchClickListener;

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_searchbar, this, true);
        search_left = findViewById(R.id.search_left);
        search_center = findViewById(R.id.search_center);
        search_layout = findViewById(R.id.search_layout);
        search_right = findViewById(R.id.search_right);
    }

    public SearchBar setSearchType(SearchType type) {
        switch (type) {
            case SEARCH:
                search_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnSearchClickListener != null) {
                            mOnSearchClickListener.OnSearchClick(search_center.getText().toString().trim());
                        }
                    }
                });

                search_center.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == KeyEvent.ACTION_DOWN) {
                            if (mOnSearchClickListener != null) {
                                mOnSearchClickListener.OnSearchClick(search_center.getText().toString().trim());
                            }
                        }
                        return false;
                    }
                });
                break;
            case NOSEARCH:
                search_center.setInputType(InputType.TYPE_NULL);
                search_center.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            if (mOnNoSearchClickListener != null) {
                                mOnNoSearchClickListener.OnNoSearchClick();
                            }
                        }
                        return false;
                    }
                });

                search_right.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnNoSearchClickListener != null) {
                            mOnNoSearchClickListener.OnNoSearchClick();
                        }
                    }
                });

                break;
            default:
                break;
        }
        return this;
    }

    public SearchBar setOnLeftClickListener(View.OnClickListener onLeftClickListener) {
        search_left.setOnClickListener(onLeftClickListener);
        return this;
    }

    public SearchBar setOnNoSearClickListener(OnNoSearchClickListener mOnNoSearchClickListener) {
        this.mOnNoSearchClickListener = mOnNoSearchClickListener;
        return this;
    }

    public SearchBar setOnSearchClickListener(OnSearchClickListener mOnSearchClickListener) {
        this.mOnSearchClickListener = mOnSearchClickListener;
        return this;
    }


//    public void setSearchBackground(int color){
//        search__status.setBackgroundColor(color);
//        search_layout.setBackgroundColor(color);
//    }


    public EditText getSearchEdittext() {
        return search_center;
    }

    public enum SearchType {
        SEARCH, NOSEARCH;
    }

    public interface OnNoSearchClickListener {
        void OnNoSearchClick();
    }

    public interface OnSearchClickListener {
        void OnSearchClick(String keyword);
    }
}