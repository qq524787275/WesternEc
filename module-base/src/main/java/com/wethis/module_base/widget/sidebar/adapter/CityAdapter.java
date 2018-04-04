package com.wethis.module_base.widget.sidebar.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.wethis.module_base.R;
import com.wethis.module_base.widget.sidebar.bean.City;

import java.util.List;

/**
 * 作者: Zzc on 2018-03-08.
 * 版本: v1.0
 */

public class CityAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {
    public static final int TYPE_CITY=0;
    public static final int TYPE_TIP=1;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CityAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_CITY, R.layout.item_city);
        addItemType(TYPE_TIP,R.layout.item_tip);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        City c=(City)item;
        Log.i(TAG, "convert: ----"+c.getPinyin());
        switch (helper.getItemViewType()) {
            case TYPE_CITY:
                helper.setText(R.id.item_city_name,c.getName());
                break;
            case TYPE_TIP:
                helper.setText(R.id.item_tip_name,c.getName());
                break;
            default:
                break;
        }
    }

    public int getLetterPosition(String letter) {
        for (int i = 0 ; i < getData().size(); i++){
            if(getData().get(i).getItemType() ==1 && ((City)getData().get(i)).getPinyin().equals(letter)){
                return i;
            }
        }
        return -1;
    }
}
