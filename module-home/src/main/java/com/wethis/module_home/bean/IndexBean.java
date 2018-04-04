package com.wethis.module_home.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 作者: Zzc on 2017-12-18.
 * 版本: v1.0
 */

public class IndexBean {
    public static final int BANNER = 0;
    public static final int NAVIGATION = 1;
    public static final int HOT = 2;
    public static final int SHOPLIST = 3;
    public static final int SHOPSTORE = 4;


    private PlatAdvListBean plat_adv_list;
    private List<TradePriceBean> trade_price;
    private List<BlockListBean> block_list;

    public PlatAdvListBean getPlat_adv_list() {
        return plat_adv_list;
    }

    public void setPlat_adv_list(PlatAdvListBean plat_adv_list) {
        this.plat_adv_list = plat_adv_list;
    }

    public List<TradePriceBean> getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(List<TradePriceBean> trade_price) {
        this.trade_price = trade_price;
    }

    public List<BlockListBean> getBlock_list() {
        return block_list;
    }

    public void setBlock_list(List<BlockListBean> block_list) {
        this.block_list = block_list;
    }

    public static class PlatAdvListBean implements MultiItemEntity{
        /**
         * ap_id : 0
         * ap_height : 100%
         * ap_width : 100%
         * adv_list : [{"adv_title":"无","adv_url":"#","adv_image":"http://www.winthis.cn/upload/default/ajax-loader.gif","background":"#FFFFFF"}]
         */

        private int ap_id;
        private String ap_height;
        private String ap_width;
        private List<AdvListBean> adv_list;

        public int getAp_id() {
            return ap_id;
        }

        public void setAp_id(int ap_id) {
            this.ap_id = ap_id;
        }

        public String getAp_height() {
            return ap_height;
        }

        public void setAp_height(String ap_height) {
            this.ap_height = ap_height;
        }

        public String getAp_width() {
            return ap_width;
        }

        public void setAp_width(String ap_width) {
            this.ap_width = ap_width;
        }

        public List<AdvListBean> getAdv_list() {
            return adv_list;
        }

        public void setAdv_list(List<AdvListBean> adv_list) {
            this.adv_list = adv_list;
        }

        @Override
        public int getItemType() {
            return  BANNER;
        }

        public static class AdvListBean {
            /**
             * adv_title : 无
             * adv_url : #
             * adv_image : http://www.winthis.cn/upload/default/ajax-loader.gif
             * background : #FFFFFF
             */

            private String adv_title;
            private String adv_url;
            private String adv_image;
            private String background;

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getAdv_url() {
                return adv_url;
            }

            public void setAdv_url(String adv_url) {
                this.adv_url = adv_url;
            }

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getBackground() {
                return background;
            }

            public void setBackground(String background) {
                this.background = background;
            }
        }
    }

    public static class TradePriceBean {
        /**
         * trade_date : 1519660800
         * trade_price : 2
         */

        private int trade_date;
        private float trade_price;

        public int getTrade_date() {
            return trade_date;
        }

        public void setTrade_date(int trade_date) {
            this.trade_date = trade_date;
        }

        public float getTrade_price() {
            return trade_price;
        }

        public void setTrade_price(float trade_price) {
            this.trade_price = trade_price;
        }
    }

    public static class BlockListBean implements MultiItemEntity{

        private int id;
        private int shop_id;
        private String category_name;
        private int category_id;
        private String category_alias;
        private String color;
        private int is_show;
        private int is_show_lower_category;
        private int is_show_brand;
        private int sort;
        private String ad_picture;
        private int create_time;
        private int modify_time;
        private String short_name;
        private int goods_sort_type;
        private List<GoodsListBean> goods_list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_alias() {
            return category_alias;
        }

        public void setCategory_alias(String category_alias) {
            this.category_alias = category_alias;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getIs_show() {
            return is_show;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }

        public int getIs_show_lower_category() {
            return is_show_lower_category;
        }

        public void setIs_show_lower_category(int is_show_lower_category) {
            this.is_show_lower_category = is_show_lower_category;
        }

        public int getIs_show_brand() {
            return is_show_brand;
        }

        public void setIs_show_brand(int is_show_brand) {
            this.is_show_brand = is_show_brand;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getAd_picture() {
            return ad_picture;
        }

        public void setAd_picture(String ad_picture) {
            this.ad_picture = ad_picture;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getModify_time() {
            return modify_time;
        }

        public void setModify_time(int modify_time) {
            this.modify_time = modify_time;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public int getGoods_sort_type() {
            return goods_sort_type;
        }

        public void setGoods_sort_type(int goods_sort_type) {
            this.goods_sort_type = goods_sort_type;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        @Override
        public int getItemType() {
            return SHOPLIST;
        }

        public static class GoodsListBean {
            /**
             * goods_id : 13
             * goods_name : 哥弟秋冬新款双面呢大衣女100%羊毛欧美长款外套A400016
             * shop_id : 0
             * category_id : 6
             * brand_id : 0
             * group_id_array :
             * promotion_type : 0
             * goods_type : 1
             * market_price : 2156.00
             * price : 1156.00
             * promotion_price : 1156.00
             * cost_price : 600.00
             * point_exchange_type : 0
             * point_exchange : 0
             * give_point : 0
             * is_member_discount : 0
             * shipping_fee : 0.00
             * shipping_fee_id : 0
             * stock : 372
             * max_buy : 0
             * min_stock_alarm : 15
             * clicks : 0
             * sales : 3
             * collects : 1
             * star : 0
             * evaluates : 0
             * shares : 0
             * province_id : 21
             * city_id : 232
             * picture : 20
             * keywords : 哥弟秋冬新款双面呢大衣女100%羊毛欧美长款外套A400016
             * introduction : 双面呢 100%羊毛
             * description : <p>品牌名称：<span class="J_EbrandLogo" target="_blank" href="//brand.tmall.com/brandInfo.htm?brandId=60499&type=0&scm=1048.1.1.4" style="margin: 0px; padding: 0px; color: rgb(51, 51, 51);">Girdear/哥弟</span></p><p class="attr-list-hd tm-clear" style="margin-top: 0px; margin-bottom: 0px; padding: 5px 20px; line-height: 22px; color: rgb(153, 153, 153); font-family: tahoma, arial, 微软雅黑, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; font-weight: 700; float: left;">产品参数：</span></p><ul id="J_AttrUL" style="list-style-type: none;" class=" list-paddingleft-2"><li><p>材质成分:&nbsp;羊毛100%</p></li><li><p>销售渠道类型:&nbsp;商场同款(线上线下都销售)</p></li><li><p>品牌:&nbsp;Girdear/哥弟</p></li><li><p>货号:&nbsp;A400016</p></li><li><p>服装版型:&nbsp;直筒</p></li><li><p>风格:&nbsp;街头</p></li><li><p>街头:&nbsp;欧美</p></li><li><p>衣长:&nbsp;长款</p></li><li><p>袖长:&nbsp;九分袖</p></li><li><p>领子:&nbsp;西装领</p></li><li><p>袖型:&nbsp;插肩袖</p></li><li><p>图案:&nbsp;纯色</p></li><li><p>适用年龄:&nbsp;30-34周岁</p></li><li><p>上市年份季节:&nbsp;2017年冬季</p></li><li><p>颜色分类:&nbsp;驼&nbsp;黑&nbsp;酒红&nbsp;浅灰&nbsp;浅绿&nbsp;静谧蓝&nbsp;焦糖&nbsp;灰白</p></li><li><p>尺码:&nbsp;S&nbsp;M&nbsp;L</p></li></ul><p><br/></p>
             * QRcode : http://www.winthis.cn/upload/winthis/goods_qrcode/goods_qrcode_13.png
             * code :
             * is_stock_visible : 1
             * is_hot : 0
             * is_recommend : 0
             * is_new : 0
             * is_pre_sale : 0
             * is_bill : 0
             * state : 1
             * sale_date : 1518488826
             * create_time : 1518488826
             * update_time : 0
             * sort : 0
             * real_sales : 0
             * brand_name : null
             * brand_pic : null
             * category_name : 女装
             * pic_cover_micro : http://www.winthis.cn/upload/winthis/goods/20180213/83ee98dbb7d72debda3bb9d6f381d3404.png
             * pic_cover_mid : http://www.winthis.cn/upload/winthis/goods/20180213/83ee98dbb7d72debda3bb9d6f381d3402.png
             * pic_cover_small : http://www.winthis.cn/upload/winthis/goods/20180213/83ee98dbb7d72debda3bb9d6f381d3403.png
             * shop_name : 官方旗舰店
             * shop_type : 1
             * pic_id : 20
             * upload_type : 1
             * domain :
             * bucket :
             * group_query : []
             * sku_list : [{"sku_id":28,"goods_id":13,"sku_name":"大号 灰色 ","attr_value_items":"2:1;1:13","attr_value_items_format":"2:1;1:13","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":29,"goods_id":13,"sku_name":"大号 白色 ","attr_value_items":"2:1;1:5","attr_value_items_format":"2:1;1:5","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":30,"goods_id":13,"sku_name":"大号 黑色 ","attr_value_items":"2:1;1:4","attr_value_items_format":"2:1;1:4","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":31,"goods_id":13,"sku_name":"大号 灰蓝色 ","attr_value_items":"2:1;1:15","attr_value_items_format":"2:1;1:15","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":32,"goods_id":13,"sku_name":"小号 灰色 ","attr_value_items":"2:2;1:13","attr_value_items_format":"2:2;1:13","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":33,"goods_id":13,"sku_name":"小号 白色 ","attr_value_items":"2:2;1:5","attr_value_items_format":"2:2;1:5","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":34,"goods_id":13,"sku_name":"小号 黑色 ","attr_value_items":"2:2;1:4","attr_value_items_format":"2:2;1:4","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":35,"goods_id":13,"sku_name":"小号 灰蓝色 ","attr_value_items":"2:2;1:15","attr_value_items_format":"2:2;1:15","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":36,"goods_id":13,"sku_name":"中号 灰色 ","attr_value_items":"2:14;1:13","attr_value_items_format":"2:14;1:13","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488826,"update_date":0},{"sku_id":37,"goods_id":13,"sku_name":"中号 白色 ","attr_value_items":"2:14;1:5","attr_value_items_format":"2:14;1:5","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488827,"update_date":0},{"sku_id":38,"goods_id":13,"sku_name":"中号 黑色 ","attr_value_items":"2:14;1:4","attr_value_items_format":"2:14;1:4","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488827,"update_date":0},{"sku_id":39,"goods_id":13,"sku_name":"中号 灰蓝色 ","attr_value_items":"2:14;1:15","attr_value_items_format":"2:14;1:15","market_price":"2156.00","price":"1156.00","promote_price":"1156.00","cost_price":"600.00","stock":31,"picture":0,"code":"123456","QRcode":"","create_date":1518488827,"update_date":0}]
             */

            private int goods_id;
            private String goods_name;
            private int shop_id;
            private int category_id;
            private int brand_id;
            private String group_id_array;
            private int promotion_type;
            private int goods_type;
            private String market_price;
            private String price;
            private String promotion_price;
            private String cost_price;
            private int point_exchange_type;
            private int point_exchange;
            private int give_point;
            private int is_member_discount;
            private String shipping_fee;
            private int shipping_fee_id;
            private int stock;
            private int max_buy;
            private int min_stock_alarm;
            private int clicks;
            private int sales;
            private int collects;
            private int star;
            private int evaluates;
            private int shares;
            private int province_id;
            private int city_id;
            private int picture;
            private String keywords;
            private String introduction;
            private String description;
            private String QRcode;
            private String code;
            private int is_stock_visible;
            private int is_hot;
            private int is_recommend;
            private int is_new;
            private int is_pre_sale;
            private int is_bill;
            private int state;
            private int sale_date;
            private int create_time;
            private int update_time;
            private int sort;
            private int real_sales;
            private Object brand_name;
            private Object brand_pic;
            private String category_name;
            private String pic_cover_micro;
            private String pic_cover_mid;
            private String pic_cover_small;
            private String shop_name;
            private int shop_type;
            private int pic_id;
            private int upload_type;
            private String domain;
            private String bucket;
            private List<?> group_query;
            private List<SkuListBean> sku_list;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public String getGroup_id_array() {
                return group_id_array;
            }

            public void setGroup_id_array(String group_id_array) {
                this.group_id_array = group_id_array;
            }

            public int getPromotion_type() {
                return promotion_type;
            }

            public void setPromotion_type(int promotion_type) {
                this.promotion_type = promotion_type;
            }

            public int getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPromotion_price() {
                return promotion_price;
            }

            public void setPromotion_price(String promotion_price) {
                this.promotion_price = promotion_price;
            }

            public String getCost_price() {
                return cost_price;
            }

            public void setCost_price(String cost_price) {
                this.cost_price = cost_price;
            }

            public int getPoint_exchange_type() {
                return point_exchange_type;
            }

            public void setPoint_exchange_type(int point_exchange_type) {
                this.point_exchange_type = point_exchange_type;
            }

            public int getPoint_exchange() {
                return point_exchange;
            }

            public void setPoint_exchange(int point_exchange) {
                this.point_exchange = point_exchange;
            }

            public int getGive_point() {
                return give_point;
            }

            public void setGive_point(int give_point) {
                this.give_point = give_point;
            }

            public int getIs_member_discount() {
                return is_member_discount;
            }

            public void setIs_member_discount(int is_member_discount) {
                this.is_member_discount = is_member_discount;
            }

            public String getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(String shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public int getShipping_fee_id() {
                return shipping_fee_id;
            }

            public void setShipping_fee_id(int shipping_fee_id) {
                this.shipping_fee_id = shipping_fee_id;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public int getMax_buy() {
                return max_buy;
            }

            public void setMax_buy(int max_buy) {
                this.max_buy = max_buy;
            }

            public int getMin_stock_alarm() {
                return min_stock_alarm;
            }

            public void setMin_stock_alarm(int min_stock_alarm) {
                this.min_stock_alarm = min_stock_alarm;
            }

            public int getClicks() {
                return clicks;
            }

            public void setClicks(int clicks) {
                this.clicks = clicks;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public int getCollects() {
                return collects;
            }

            public void setCollects(int collects) {
                this.collects = collects;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public int getEvaluates() {
                return evaluates;
            }

            public void setEvaluates(int evaluates) {
                this.evaluates = evaluates;
            }

            public int getShares() {
                return shares;
            }

            public void setShares(int shares) {
                this.shares = shares;
            }

            public int getProvince_id() {
                return province_id;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public int getPicture() {
                return picture;
            }

            public void setPicture(int picture) {
                this.picture = picture;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getQRcode() {
                return QRcode;
            }

            public void setQRcode(String QRcode) {
                this.QRcode = QRcode;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getIs_stock_visible() {
                return is_stock_visible;
            }

            public void setIs_stock_visible(int is_stock_visible) {
                this.is_stock_visible = is_stock_visible;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }

            public int getIs_recommend() {
                return is_recommend;
            }

            public void setIs_recommend(int is_recommend) {
                this.is_recommend = is_recommend;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public int getIs_pre_sale() {
                return is_pre_sale;
            }

            public void setIs_pre_sale(int is_pre_sale) {
                this.is_pre_sale = is_pre_sale;
            }

            public int getIs_bill() {
                return is_bill;
            }

            public void setIs_bill(int is_bill) {
                this.is_bill = is_bill;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getSale_date() {
                return sale_date;
            }

            public void setSale_date(int sale_date) {
                this.sale_date = sale_date;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getReal_sales() {
                return real_sales;
            }

            public void setReal_sales(int real_sales) {
                this.real_sales = real_sales;
            }

            public Object getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(Object brand_name) {
                this.brand_name = brand_name;
            }

            public Object getBrand_pic() {
                return brand_pic;
            }

            public void setBrand_pic(Object brand_pic) {
                this.brand_pic = brand_pic;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getPic_cover_micro() {
                return pic_cover_micro;
            }

            public void setPic_cover_micro(String pic_cover_micro) {
                this.pic_cover_micro = pic_cover_micro;
            }

            public String getPic_cover_mid() {
                return pic_cover_mid;
            }

            public void setPic_cover_mid(String pic_cover_mid) {
                this.pic_cover_mid = pic_cover_mid;
            }

            public String getPic_cover_small() {
                return pic_cover_small;
            }

            public void setPic_cover_small(String pic_cover_small) {
                this.pic_cover_small = pic_cover_small;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public int getShop_type() {
                return shop_type;
            }

            public void setShop_type(int shop_type) {
                this.shop_type = shop_type;
            }

            public int getPic_id() {
                return pic_id;
            }

            public void setPic_id(int pic_id) {
                this.pic_id = pic_id;
            }

            public int getUpload_type() {
                return upload_type;
            }

            public void setUpload_type(int upload_type) {
                this.upload_type = upload_type;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public List<?> getGroup_query() {
                return group_query;
            }

            public void setGroup_query(List<?> group_query) {
                this.group_query = group_query;
            }

            public List<SkuListBean> getSku_list() {
                return sku_list;
            }

            public void setSku_list(List<SkuListBean> sku_list) {
                this.sku_list = sku_list;
            }

            public static class SkuListBean {
                /**
                 * sku_id : 28
                 * goods_id : 13
                 * sku_name : 大号 灰色
                 * attr_value_items : 2:1;1:13
                 * attr_value_items_format : 2:1;1:13
                 * market_price : 2156.00
                 * price : 1156.00
                 * promote_price : 1156.00
                 * cost_price : 600.00
                 * stock : 31
                 * picture : 0
                 * code : 123456
                 * QRcode :
                 * create_date : 1518488826
                 * update_date : 0
                 */

                private int sku_id;
                private int goods_id;
                private String sku_name;
                private String attr_value_items;
                private String attr_value_items_format;
                private String market_price;
                private String price;
                private String promote_price;
                private String cost_price;
                private int stock;
                private int picture;
                private String code;
                private String QRcode;
                private int create_date;
                private int update_date;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSku_name() {
                    return sku_name;
                }

                public void setSku_name(String sku_name) {
                    this.sku_name = sku_name;
                }

                public String getAttr_value_items() {
                    return attr_value_items;
                }

                public void setAttr_value_items(String attr_value_items) {
                    this.attr_value_items = attr_value_items;
                }

                public String getAttr_value_items_format() {
                    return attr_value_items_format;
                }

                public void setAttr_value_items_format(String attr_value_items_format) {
                    this.attr_value_items_format = attr_value_items_format;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPromote_price() {
                    return promote_price;
                }

                public void setPromote_price(String promote_price) {
                    this.promote_price = promote_price;
                }

                public String getCost_price() {
                    return cost_price;
                }

                public void setCost_price(String cost_price) {
                    this.cost_price = cost_price;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getPicture() {
                    return picture;
                }

                public void setPicture(int picture) {
                    this.picture = picture;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getQRcode() {
                    return QRcode;
                }

                public void setQRcode(String QRcode) {
                    this.QRcode = QRcode;
                }

                public int getCreate_date() {
                    return create_date;
                }

                public void setCreate_date(int create_date) {
                    this.create_date = create_date;
                }

                public int getUpdate_date() {
                    return update_date;
                }

                public void setUpdate_date(int update_date) {
                    this.update_date = update_date;
                }
            }
        }
    }
}
