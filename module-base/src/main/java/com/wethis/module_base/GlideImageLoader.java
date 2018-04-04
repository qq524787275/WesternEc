package com.wethis.module_base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Zzc on 2017/11/6/006.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).
                load(path).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                thumbnail(0.5f).
                priority(Priority.HIGH).
                placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).
                fallback(R.mipmap.ic_launcher).
                into(imageView);
//         Glide.with(context).load(path).placeholder(R.mipmap.logo).into(imageView);
    }
}
