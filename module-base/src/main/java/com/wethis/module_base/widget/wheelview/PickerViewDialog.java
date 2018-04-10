//package com.wethis.module_base.widget.wheelview.adapters;
//
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.lzy.okgo.OkGo;
//import com.lzy.okgo.model.Response;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import cn.minsutx.hostay.base.Constants;
//import cn.minsutx.hostay.base.widget.dialog.BaseNiceDialog;
//import cn.minsutx.hostay.base.widget.dialog.ViewHolder;
//import cn.minsutx.hostay.base.widget.wheelview.AbstractWheel;
//import cn.minsutx.hostay.base.widget.wheelview.AbstractWheelView;
//import cn.minsutx.hostay.base.widget.wheelview.OnWheelClickedListener;
//import cn.minsutx.hostay.base.widget.wheelview.OnWheelScrollListener;
//import cn.minsutx.hostay.base.widget.wheelview.WheelVerticalView;
//import cn.minsutx.hostay.zzc.R;
//import cn.minsutx.hostay.zzc.bean.CityBean;
//import cn.minsutx.hostay.zzc.callback.BaseResponse;
//import cn.minsutx.hostay.zzc.callback.JsonCallback;
//
///**
// * 作者: Zzc on 2017-12-07.
// * 版本: v1.0
// */
//
//public class PickerViewDialog<T> extends BaseNiceDialog {
//    public TextView mLeft, mRight;
//    public WheelVerticalView mOptions1, mOptions2, mOptions3;
//    private List<CityBean> mListProvince;
//    private List<CityBean> mListCity;
//    private List<CityBean> mListDistrict;
//    public static final int LEVEL1 = 1;//第一级别
//    public static final int LEVEL2 = 2;//第二级别
//    public static final int LEVEL3 = 3;//第三级别
//    private OnOptionsListener onOptionsListener;
//    @Override
//    public int intLayoutId() {
//         return R.layout.layout_picker;
//    }
//
//    @Override
//    public void convertView(ViewHolder holder, BaseNiceDialog dialog) {
//        initView(holder);
//        initEvent();
//        initData();
//
//    }
//
//    private void initData() {
//        getRegion(null, LEVEL1);
//    }
//
//    private void initEvent() {
//        mOptions1.addClickingListener(new OnWheelClickedListener() {
//            @Override
//            public void onItemClicked(AbstractWheel wheel, int itemIndex) {
//                Toast.makeText(getContext(), "" + itemIndex, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mOptions1.addScrollingListener(new OnWheelScrollListener() {
//            @Override
//            public void onScrollingStarted(AbstractWheel wheel) {
//
//            }
//
//            @Override
//            public void onScrollingFinished(AbstractWheel wheel) {
//                getRegion(mListProvince.get(wheel.getCurrentItem()).getId(), LEVEL2);
//            }
//        });
//
//        mOptions2.addScrollingListener(new OnWheelScrollListener() {
//            @Override
//            public void onScrollingStarted(AbstractWheel wheel) {
//
//            }
//
//            @Override
//            public void onScrollingFinished(AbstractWheel wheel) {
//                getRegion(mListCity.get(wheel.getCurrentItem()).getId(), LEVEL3);
//            }
//        });
//
//        mLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });
//
//        mRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                int currentItem1 = mOptions1.getCurrentItem();
//                int currentItem2 = mOptions2.getCurrentItem();
//                int currentItem3 = mOptions3.getCurrentItem();
//
//                if(onOptionsListener!=null)
//                    onOptionsListener.opstion(mListProvince.get(currentItem1)
//                            ,mListCity.get(currentItem2)
//                            ,mListDistrict.get(currentItem3));
//                dismiss();
//            }
//        });
//    }
//
//    private void initView(ViewHolder holder) {
//        mLeft = holder.getView(R.id.left);
//        mRight = holder.getView(R.id.right);
//        mOptions1 = holder.getView(R.id.options1);
//        mOptions2 = holder.getView(R.id.options2);
//        mOptions3 = holder.getView(R.id.options3);
//        initWheelStyle(mOptions1);
//        initWheelStyle(mOptions2);
//        initWheelStyle(mOptions3);
//    }
//
//
//    /**
//     * @param id 上级地区代码，如传0或空，则返回省
//     */
//    public void getRegion(String id, final int level) {
//        OkGo.<BaseResponse<List<CityBean>>>post(Constants.URL_GETREGION)
//                .tag(this)
//                .params("id", id)
//                .execute(new JsonCallback<BaseResponse<List<CityBean>>>() {
//                    @Override
//                    public void onSuccess(Response<BaseResponse<List<CityBean>>> response) {
//                        List<CityBean> list = response.body().result;
//                        if (level == LEVEL1) {
//                            mListProvince = checkList(list, LEVEL1);
//                            mOptions1.setViewAdapter(new ListWheelAdapter(getContext(), mListProvince));
//                            getRegion(mListProvince.get(0).getId(), LEVEL2);
//                        } else if (level == LEVEL2) {
//                            mListCity = checkList(list, LEVEL2);
//                            mOptions2.setCurrentItem(0);
//                            mOptions2.setViewAdapter(new ListWheelAdapter(getContext(), mListCity));
//                            getRegion(mListCity.get(0).getId(), LEVEL3);
//                        } else if (level == LEVEL3) {
//                            mListDistrict = checkList(list, LEVEL3);
//                            mOptions3.setCurrentItem(0);
//                            mOptions3.setViewAdapter(new ListWheelAdapter(getContext(), mListDistrict));
//                        } else {
//
//                        }
//                    }
//                });
//    }
//
//    private List<CityBean> checkList(List<CityBean> list, int level) {
//        if (list == null || list.size() == 0) {
//            list = new ArrayList<>();
//            list.add(new CityBean("-1", "", level + ""));
//            return list;
//        }
//        return list;
//    }
//
//    private void initWheelStyle(AbstractWheelView wheel) {
//        wheel.setCyclic(false);
//        wheel.setVisibleItems(5);
//        wheel.setActiveCoeff(0.8f);
//        wheel.setPassiveCoeff(0.6f);
//
//        // test
//        wheel.setSelectionDivider(new ColorDrawable(Color.BLACK));
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        OkGo.getInstance().cancelTag(this);
//    }
//
//    public void setOnOptionsListener(OnOptionsListener onOptionsListener){
//        this.onOptionsListener=onOptionsListener;
//    }
//
//    public interface OnOptionsListener{
//        void opstion(CityBean bean1, CityBean bean2, CityBean bean3);
//    }
//}
