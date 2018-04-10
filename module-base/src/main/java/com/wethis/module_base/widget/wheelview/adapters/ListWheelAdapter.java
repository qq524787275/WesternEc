package com.wethis.module_base.widget.wheelview.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import com.wethis.module_base.R;
import com.wethis.module_base.widget.wheelview.IPickerViewData;

import java.util.List;


/**
 * 作者: Zzc on 2017-12-08.
 * 版本: v1.0
 */

public class ListWheelAdapter<T> extends AbstractWheelTextAdapter {
    private List<T> mList;

    public ListWheelAdapter(Context context, List<T> mList) {
        super(context);
        this.mList=mList;
        sharedConstructor();
    }

    private void sharedConstructor() {
        itemResourceId = R.layout.base_item_picker;
        itemTextResourceId = R.id.tv;
        emptyItemResourceId = R.layout.base_item_picker;
        setTextTypeface(Typeface.DEFAULT);
        setTextColor(Color.parseColor("#999999"));
    }

    @Override
    protected void onConfigureTextView(TextView textView, boolean isSelectedItem) {
        super.onConfigureTextView(textView, isSelectedItem);
        if(isSelectedItem) {
            textView.setTextColor(Color.parseColor("#333333"));
        } else {
            textView.setTextColor(getTextColor());
        }
    }

    @Override
    public int getItemsCount() {
        return mList.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        if (index >= 0 && index < mList.size()) {
            T item = mList.get(index);
            if (item instanceof IPickerViewData) {
                return  ((IPickerViewData) item).getText();
            }
            return item.toString();
        }
        return null;
    }
}
