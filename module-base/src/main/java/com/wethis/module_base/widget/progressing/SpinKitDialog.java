package com.wethis.module_base.widget.progressing;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.wethis.module_base.R;
import com.wethis.module_base.utils.DensityUtils;


/**
 * 作者: Zzc on 2018-03-28.
 * 版本: v1.0
 */

public class SpinKitDialog {

    private QMUIDialog mDialog;
    private SpinKitView mKitView;

    private SpinKitDialog(Context context,Style style,int color) {
        mDialog = new QMUIDialog
                .CustomDialogBuilder(context)
                .setLayout(R.layout.dialog_spinkit)
                .create();

        mKitView=mDialog.findViewById(R.id.spinktview);
        LinearLayout layout= mDialog.findViewById(R.id.dialog);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width= DensityUtils.getScreenW(context)/3;
//        layoutParams.rightMargin=DensityUtils.getScreenW(context)/3;
        layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
        layout.setLayoutParams(layoutParams);



        mKitView.setColor(color);
        mKitView.setIndeterminateDrawable(SpriteFactory.create(style));

        WindowManager.LayoutParams attributes = mDialog.getWindow().getAttributes();
        attributes.windowAnimations=R.style.WindowAlphaAnimation;
    }

    public static class Builder {
        private Context mContext;
        private int mColor;
        private Style mStyle;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setColor(int color){
            mColor=color;
            return this;
        }

        public Builder setStyle(Style style){
            mStyle=style;
            return this;
        }

        public SpinKitDialog builder() {
            return new SpinKitDialog(mContext,mStyle,mColor);
        }
    }

    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }

    public QMUIDialog getQMUIDialog() {
        return mDialog;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener){
        mDialog.setOnDismissListener(onDismissListener);
    }
}
