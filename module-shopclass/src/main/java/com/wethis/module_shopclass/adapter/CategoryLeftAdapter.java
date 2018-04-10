package com.wethis.module_shopclass.adapter;

import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wethis.module_shopclass.R;
import com.wethis.module_shopclass.bean.CategoryBean;

import java.util.ArrayList;


/**
 * Created by Zzc on 2017/11/2/002.
 */

public class CategoryLeftAdapter extends BaseQuickAdapter<CategoryBean,BaseViewHolder> {

    private int current=0;

    public CategoryLeftAdapter() {
        super(R.layout.shopclass_item_category_left,new ArrayList<CategoryBean>());
    }



    @Override
    protected void convert(BaseViewHolder helper, CategoryBean item) {
        TextView item_tv= helper.getView(R.id.item_category_left_tv);
        if(current==helper.getAdapterPosition()){
            item_tv.setBackgroundColor(ContextCompat.getColor(mContext,R.color.bg_all));
            item_tv.setTextColor(ContextCompat.getColor(mContext,R.color.red_ff5354));
        }else{
            item_tv.setBackgroundColor(ContextCompat.getColor(mContext,R.color.white));
            item_tv.setTextColor(ContextCompat.getColor(mContext,R.color.black_333));
        }

        helper.setText(R.id.item_category_left_tv,item.getCategory_name());
    }

    public void setCurrent(int current){
        this.current=current;
        notifyDataSetChanged();
    }

}
