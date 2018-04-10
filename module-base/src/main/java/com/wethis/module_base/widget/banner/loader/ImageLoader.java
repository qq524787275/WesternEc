package com.wethis.module_base.widget.banner.loader;

import android.content.Context;
import android.widget.ImageView;


public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }

}
