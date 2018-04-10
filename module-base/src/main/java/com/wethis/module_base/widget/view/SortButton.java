package com.wethis.module_base.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wethis.module_base.R;

/**
 * 作者: Zzc on 2018-04-10.
 * 版本: v1.0
 */

public class SortButton extends LinearLayout {
    private TextView mText;
    private ImageView mImage;
    private Context mContext;
    private Status status=Status.NORMAL;
    private OnSortClickListener mOnSortClickListener;

    public SortButton(Context context) {
        this(context,null);
    }

    public SortButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SortButton(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        LayoutInflater.from(context).inflate(R.layout.view_sort_button,this,true);
        mText=findViewById(R.id.custom_shopsort_tv);
        mImage=findViewById(R.id.custom_shopsort_img);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShopSortButton);
        String text=typedArray.getString(R.styleable.ShopSortButton_text);
        typedArray.recycle();
        mText.setText(text);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (status) {
                    case NORMAL:
                        setStatus(Status.UP);
                        break;
                    case UP:
                        setStatus(Status.DOWN);
                        break;
                    case DOWN:
                        setStatus(Status.UP);
                        break;
                    default:
                        break;
                }
                if(mOnSortClickListener!=null){
                    mOnSortClickListener.OnSortClick(status,SortButton.this);
                }
            }
        });
    }


    public void setOnSortClickListener(OnSortClickListener mOnSortClickListener){
        this.mOnSortClickListener=mOnSortClickListener;
    }



    public interface OnSortClickListener{
        void OnSortClick(Status status,View view);
    }

    public void setStatus(Status status){
        switch (status) {
            case NORMAL:
                mText.setTextColor(ContextCompat.getColor(mContext,R.color.black_222));
                mImage.setImageResource(R.mipmap.side_normal);
                SortButton.this.status=Status.NORMAL;
                break;
            case UP:
                mText.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff5354));
                mImage.setImageResource(R.mipmap.side_up_select);
                SortButton.this.status=Status.UP;
                break;
            case DOWN:
                mText.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff5354));
                mImage.setImageResource(R.mipmap.side_down_select);
                SortButton.this.status=Status.DOWN;
                break;
            case SELECT:
                mText.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff5354));
                mImage.setImageResource(R.mipmap.side_normal);
                SortButton.this.status=Status.SELECT;
                break;
            default:
                break;
        }
    }

    public enum Status{
        NORMAL,UP,DOWN,SELECT
    }
}
