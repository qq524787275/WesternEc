package com.wethis.module_shopclass.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.wethis.module_shopclass.adapter.CategoryRightAdapter;

import java.util.List;

/**
 * Created by Zzc on 2017/11/13/013.
 */

public class CategoryBean implements Parcelable{

        /**
         * category_id : 1
         * category_name : 控制系统
         * short_name : 控制系统
         * pid : 0
         * level : 1
         * is_visible : 1
         * attr_id : 0
         * attr_name :
         * keywords :
         * description :
         * sort : 0
         * category_pic :
         * is_parent : 1
         * child_list : [{"category_id":4,"category_name":"控制柜","short_name":"控制柜","pid":1,"level":2,"is_visible":1,"attr_id":6,"attr_name":"控制柜","keywords":"","description":"","sort":0,"category_pic":"","is_parent":1,"child_list":[{"category_id":19,"category_name":"商品分类","short_name":"商品分类简称","pid":4,"level":3,"is_visible":1,"attr_id":4,"attr_name":"XHB3-A召唤盒","keywords":"关键字","description":"描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510884865.jpg","is_parent":0},{"category_id":23,"category_name":"三级控制柜","short_name":"三级控制柜","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜","description":"三级控制柜三级控制柜","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885447.jpg","is_parent":0},{"category_id":24,"category_name":"三级控制柜1","short_name":"三级控制柜1","pid":4,"level":3,"is_visible":1,"attr_id":1,"attr_name":"驱动器","keywords":"三级控制柜1","description":"三级控制柜1","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885484.jpg","is_parent":0},{"category_id":25,"category_name":"三级控制柜2","short_name":"三级控制柜2","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜2","description":"三级控制柜2","sort":0,"category_pic":"","is_parent":0},{"category_id":26,"category_name":"三级控制柜4","short_name":"三级控制柜4","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜4","description":"三级控制柜4","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885516.jpg","is_parent":0}]},{"category_id":5,"category_name":"主板","short_name":"主板","pid":1,"level":2,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"","description":"","sort":0,"category_pic":"","is_parent":1,"child_list":[{"category_id":27,"category_name":"三级主板1号","short_name":"三级主板1号","pid":5,"level":3,"is_visible":1,"attr_id":2,"attr_name":"主机","keywords":"三级主板1号","description":"三级主板1号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885558.jpg","is_parent":0},{"category_id":28,"category_name":"三级主板2号","short_name":"三级主板2号","pid":5,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级主板2号","description":"三级主板2号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885584.jpg","is_parent":0},{"category_id":29,"category_name":"三级主板3号","short_name":"三级主板3号","pid":5,"level":3,"is_visible":1,"attr_id":4,"attr_name":"XHB3-A召唤盒","keywords":"三级主板3号","description":"三级主板3号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885603.jpg","is_parent":0},{"category_id":30,"category_name":"三级主板4号","short_name":"三级主板4号","pid":5,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级主板4号","description":"三级主板4号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885621.jpg","is_parent":0}]},{"category_id":6,"category_name":"驱动器","short_name":"驱动器","pid":1,"level":2,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"","description":"","sort":0,"category_pic":"","is_parent":1,"child_list":[{"category_id":31,"category_name":"三级驱动器1号","short_name":"三级驱动器1号","pid":6,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级驱动器1号","description":"三级驱动器1号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885711.jpg","is_parent":0}]},{"category_id":7,"category_name":"通讯板","short_name":"通讯板","pid":1,"level":2,"is_visible":0,"attr_id":0,"attr_name":"","keywords":"","description":"","sort":0,"category_pic":"","is_parent":1,"child_list":[{"category_id":32,"category_name":"三级通讯板1号","short_name":"三级通讯板1号","pid":7,"level":3,"is_visible":1,"attr_id":5,"attr_name":"通讯板","keywords":"三级通讯板1号","description":"三级通讯板1号","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885739.jpg","is_parent":0}]}]
         */

        private int category_id;
        private String category_name;
        private String short_name;
        private int pid;
        private int level;
        private int is_visible;
        private int attr_id;
        private String attr_name;
        private String keywords;
        private String description;
        private int sort;
        private String category_pic;
        private int is_parent;
        private List<ChildListBeanX> child_list;

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getIs_visible() {
            return is_visible;
        }

        public void setIs_visible(int is_visible) {
            this.is_visible = is_visible;
        }

        public int getAttr_id() {
            return attr_id;
        }

        public void setAttr_id(int attr_id) {
            this.attr_id = attr_id;
        }

        public String getAttr_name() {
            return attr_name;
        }

        public void setAttr_name(String attr_name) {
            this.attr_name = attr_name;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getCategory_pic() {
            return category_pic;
        }

        public void setCategory_pic(String category_pic) {
            this.category_pic = category_pic;
        }

        public int getIs_parent() {
            return is_parent;
        }

        public void setIs_parent(int is_parent) {
            this.is_parent = is_parent;
        }

        public List<ChildListBeanX> getChild_list() {
            return child_list;
        }

        public void setChild_list(List<ChildListBeanX> child_list) {
            this.child_list = child_list;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static class ChildListBeanX implements MultiItemEntity{
            /**
             * category_id : 4
             * category_name : 控制柜
             * short_name : 控制柜
             * pid : 1
             * level : 2
             * is_visible : 1
             * attr_id : 6
             * attr_name : 控制柜
             * keywords :
             * description :
             * sort : 0
             * category_pic :
             * is_parent : 1
             * child_list : [{"category_id":19,"category_name":"商品分类","short_name":"商品分类简称","pid":4,"level":3,"is_visible":1,"attr_id":4,"attr_name":"XHB3-A召唤盒","keywords":"关键字","description":"描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510884865.jpg","is_parent":0},{"category_id":23,"category_name":"三级控制柜","short_name":"三级控制柜","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜","description":"三级控制柜三级控制柜","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885447.jpg","is_parent":0},{"category_id":24,"category_name":"三级控制柜1","short_name":"三级控制柜1","pid":4,"level":3,"is_visible":1,"attr_id":1,"attr_name":"驱动器","keywords":"三级控制柜1","description":"三级控制柜1","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885484.jpg","is_parent":0},{"category_id":25,"category_name":"三级控制柜2","short_name":"三级控制柜2","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜2","description":"三级控制柜2","sort":0,"category_pic":"","is_parent":0},{"category_id":26,"category_name":"三级控制柜4","short_name":"三级控制柜4","pid":4,"level":3,"is_visible":1,"attr_id":0,"attr_name":"","keywords":"三级控制柜4","description":"三级控制柜4","sort":0,"category_pic":"http://www.minjianle.com/upload/xizishop/goods_category/1510885516.jpg","is_parent":0}]
             */

            private int category_id;
            private String category_name;
            private String short_name;
            private int pid;
            private int level;
            private int is_visible;
            private int attr_id;
            private String attr_name;
            private String keywords;
            private String description;
            private int sort;
            private String category_pic;
            private int is_parent;
            private List<ChildListBean> child_list;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getIs_visible() {
                return is_visible;
            }

            public void setIs_visible(int is_visible) {
                this.is_visible = is_visible;
            }

            public int getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(int attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getCategory_pic() {
                return category_pic;
            }

            public void setCategory_pic(String category_pic) {
                this.category_pic = category_pic;
            }

            public int getIs_parent() {
                return is_parent;
            }

            public void setIs_parent(int is_parent) {
                this.is_parent = is_parent;
            }

            public List<ChildListBean> getChild_list() {
                return child_list;
            }

            public void setChild_list(List<ChildListBean> child_list) {
                this.child_list = child_list;
            }

        @Override
        public int getItemType() {
            return CategoryRightAdapter.TYPE_LEVEL_0;
        }



        public static class ChildListBean implements MultiItemEntity {
                /**
                 * category_id : 19
                 * category_name : 商品分类
                 * short_name : 商品分类简称
                 * pid : 4
                 * level : 3
                 * is_visible : 1
                 * attr_id : 4
                 * attr_name : XHB3-A召唤盒
                 * keywords : 关键字
                 * description : 描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息描述信息
                 * sort : 0
                 * category_pic : http://www.minjianle.com/upload/xizishop/goods_category/1510884865.jpg
                 * is_parent : 0
                 */

                private int category_id;
                private String category_name;
                private String short_name;
                private int pid;
                private int level;
                private int is_visible;
                private int attr_id;
                private String attr_name;
                private String keywords;
                private String description;
                private int sort;
                private String category_pic;
                private int is_parent;

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getShort_name() {
                    return short_name;
                }

                public void setShort_name(String short_name) {
                    this.short_name = short_name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public int getIs_visible() {
                    return is_visible;
                }

                public void setIs_visible(int is_visible) {
                    this.is_visible = is_visible;
                }

                public int getAttr_id() {
                    return attr_id;
                }

                public void setAttr_id(int attr_id) {
                    this.attr_id = attr_id;
                }

                public String getAttr_name() {
                    return attr_name;
                }

                public void setAttr_name(String attr_name) {
                    this.attr_name = attr_name;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getCategory_pic() {
                    return category_pic;
                }

                public void setCategory_pic(String category_pic) {
                    this.category_pic = category_pic;
                }

                public int getIs_parent() {
                    return is_parent;
                }

                public void setIs_parent(int is_parent) {
                    this.is_parent = is_parent;
                }

            @Override
            public int getItemType() {
                return CategoryRightAdapter.TYPE_LEVEL_1;
            }
        }
    }
}
