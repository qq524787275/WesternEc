package com.wethis.module_base;

/**
 * Created by Zzc on 2017/11/1/001.
 */

public class Constants {
    public static final String APP_ID = "wxf8b4f85f3a794e77";

    public static final String URL_TEST_WEXIN="http://wxpay.wxutil.com/pub_v2/app/app_pay.php";

    //域名host http://www.minjianle.com http://www.winthis.cn
    public static final String BASE_URL="http://www.winthis.cn";

    //用户注册
    public static final String URL_REGISTER=BASE_URL+"/api/user/register";

    //获取验证码
    public static final String URL_GETVERIFY=BASE_URL+"/api/user/getVerify";

    //无密码登录接口
    public static final String URL_NOPASSWORDLOGIN=BASE_URL+"/api/user/noPasswordLogin";

    //用户密码登录
    public static final String URL_LOGIN=BASE_URL+"/api/user/login";

    //忘记密码
    public static final String URL_FORGETPASSWORD=BASE_URL+"/api/user/forgetPassword";

    //获取个人资料
    public static final String URL_GETUSERINFO=BASE_URL+"/api/user/getUserInfo";

    //退出登录
    public static final String URL_LOGOUT=BASE_URL+"/api/user/logout";

    //绑定手机号
    public static final String URL_BINDMOBILE=BASE_URL+"/api/user/bindMobile";

    //获取收货地址
    public static final String URL_GETADDRESSLIST=BASE_URL+"/api/user/getAddressList";

    //设置默认收货地址接口
    public static final String URL_SETDEFAULTADDRESS=BASE_URL+"/api/user/setDefaultAddress";

    //删除收货地址接口
    public static final String URL_DELETEADDRESS=BASE_URL+"/api/user/deleteAddress";

    //修改收货地址接口
    public static final String URL_UPDATEADDRESS=BASE_URL+"/api/user/updateAddress";

    //新增收货地址接口
    public static final String URL_ADDADDRESS=BASE_URL+"/api/user/addAddress";

    //获取商品分类树接口
    public static final String URL_GETGOODSCATEGORYTREE=BASE_URL+"/api/goods/getGoodsCategoryTree";

    //获取商品列表接口
    public static final String URL_GETGOODSLIST=BASE_URL+"/api/goods/getGoodsList";

    //获取商品详情接口
    public static final String URL_GETGOODSDETAIL=BASE_URL+"/api/goods/getGoodsDetail";

    //添加购物车
    public static final String URL_ADDCART=BASE_URL+"/api/goods/addCart";

    //收藏接口
    public static final String URL_ADDFAVORITES=BASE_URL+"/api/user/addFavorites";

    //获取收藏列表
    public static final String URL_GETFAVORITESLIST=BASE_URL+"/api/user/getFavoritesList";

    //获取省列表
    public static final String URL_GETPROVINCELIST=BASE_URL+"/api/base/getProvinceList";

    //获取市列表
    public static final String URL_GETCITYLIST=BASE_URL+"/api/base/getCityList";

    //获取区县列表
    public static final String URL_GETDISTRICTLIST=BASE_URL+"/api/base/getDistrictList";

    //取消收藏接口
    public static final String URL_DELETEFAVORITES=BASE_URL+"/api/user/deleteFavorites";

    //获取购物车接口
    public static final String URL_GETCART=BASE_URL+"/api/goods/getCart";

    //修改购物车数量接口
    public static final String URL_CARTADJUSTNUM=BASE_URL+"/api/goods/cartAdjustNum";

    //删除购物车项目接口
    public static final String URL_CARTDELETE=BASE_URL+"/api/goods/cartDelete";

    //购物车结算接口
    public static final String URL_SETTLEMENT=BASE_URL+"/api/order/settlement";

    //提交订单接口
    public static final String URL_ORDERCREATE=BASE_URL+"/api/order/orderCreate";

    //获取订单列表接口
    public static final String URL_GETORDERLIST=BASE_URL+"/api/order/getOrderList";

    //获取订单详情接口
    public static final String URL_GETORDERDETAIL=BASE_URL+"/api/order/getOrderDetail";

    //提交订单接口
    public static final String URL_ORDERPAY=BASE_URL+"/api/order/orderPay";

    //关闭订单接口
    public static final String URL_CLOSEORDER=BASE_URL+"/api/order/closeOrder";

    //确认收货接口
    public static final String URL_TAKEDELIVERY=BASE_URL+"/api/order/takeDelivery";

    //删除订单接口
    public static final String URL_DELETEORDER=BASE_URL+"/api/order/deleteOrder";

    //获取APP支付请求参数接口
    public static final String URL_GETPAY=BASE_URL+"/api/pay/getpay";

    //首页接口
    public static final String URL_INDEX=BASE_URL+"/api/Index/index";

    //我的推广
    public static final String URL_MYQRCODE=BASE_URL+"/api/user/myQrcode";

    //查看物流
    public static final String URL_ORDEREXPRESS=BASE_URL+"/api/order/orderExpress";

    //查看商家资料接口
    public static final String URL_SHOP_INDEX=BASE_URL+"/api/shop/index";

    // 过渡图的图片链接
    private static final String TRANSITION_URL_01 = "http://ojyz0c8un.bkt.clouddn.com/b_1.jpg";
    private static final String TRANSITION_URL_02 = "http://ojyz0c8un.bkt.clouddn.com/b_2.jpg";
    private static final String TRANSITION_URL_03 = "http://ojyz0c8un.bkt.clouddn.com/b_3.jpg";
    private static final String TRANSITION_URL_04 = "http://ojyz0c8un.bkt.clouddn.com/b_4.jpg";
    private static final String TRANSITION_URL_05 = "http://ojyz0c8un.bkt.clouddn.com/b_5.jpg";
    private static final String TRANSITION_URL_06 = "http://ojyz0c8un.bkt.clouddn.com/b_6.jpg";
    private static final String TRANSITION_URL_07 = "http://ojyz0c8un.bkt.clouddn.com/b_7.jpg";
    private static final String TRANSITION_URL_08 = "http://ojyz0c8un.bkt.clouddn.com/b_8.jpg";
    private static final String TRANSITION_URL_09 = "http://ojyz0c8un.bkt.clouddn.com/b_9.jpg";
    private static final String TRANSITION_URL_10 = "http://ojyz0c8un.bkt.clouddn.com/b_10.jpg";
    public static final String[] TRANSITION_URLS = new String[]{
            TRANSITION_URL_01, TRANSITION_URL_02, TRANSITION_URL_03
            , TRANSITION_URL_04, TRANSITION_URL_05, TRANSITION_URL_06
            , TRANSITION_URL_07, TRANSITION_URL_08, TRANSITION_URL_09
            , TRANSITION_URL_10
    };
}
