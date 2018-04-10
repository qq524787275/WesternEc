package com.wethis.module_base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wethis.module_base.widget.banner.loader.ImageLoader;

/**
 * Created by Zzc on 2017/11/6/006.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path)
                .placeholder(R.mipmap.img_two_bi_one)
                .error(R.mipmap.img_two_bi_one)
                .crossFade(500)
                .into(imageView);
//         Glide.with(context).load(path).placeholder(R.mipmap.logo).into(imageView);
    }
}
