package com.example.item.bean;

import java.util.List;

public class HomeNewPriceBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"count":5,"totalPages":1,"pageSize":10,"currentPage":1,"data":[{"id":1134030,"name":"简约知性记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png","retail_price":46},{"id":1134032,"name":"趣味粉彩系列记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png","retail_price":49},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1135002,"name":"宫廷奢华真丝四件套","list_pic_url":"http://yanxuan.nosdn.127.net/45548f26cfd0c7c41e0afc3709d48286.png","retail_price":2599}],"filterCategory":[{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":true},{"id":1005001,"name":"餐厨","checked":false},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false}],"goodsList":[{"id":1134030,"name":"简约知性记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png","retail_price":46},{"id":1134032,"name":"趣味粉彩系列记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png","retail_price":49},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1135002,"name":"宫廷奢华真丝四件套","list_pic_url":"http://yanxuan.nosdn.127.net/45548f26cfd0c7c41e0afc3709d48286.png","retail_price":2599}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 5
         * totalPages : 1
         * pageSize : 10
         * currentPage : 1
         * data : [{"id":1134030,"name":"简约知性记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png","retail_price":46},{"id":1134032,"name":"趣味粉彩系列记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png","retail_price":49},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1135002,"name":"宫廷奢华真丝四件套","list_pic_url":"http://yanxuan.nosdn.127.net/45548f26cfd0c7c41e0afc3709d48286.png","retail_price":2599}]
         * filterCategory : [{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":true},{"id":1005001,"name":"餐厨","checked":false},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false}]
         * goodsList : [{"id":1134030,"name":"简约知性记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png","retail_price":46},{"id":1134032,"name":"趣味粉彩系列记忆棉坐垫","list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png","retail_price":49},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1135002,"name":"宫廷奢华真丝四件套","list_pic_url":"http://yanxuan.nosdn.127.net/45548f26cfd0c7c41e0afc3709d48286.png","retail_price":2599}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;
        private List<FilterCategoryBean> filterCategory;
        private List<GoodsListBean> goodsList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public List<FilterCategoryBean> getFilterCategory() {
            return filterCategory;
        }

        public void setFilterCategory(List<FilterCategoryBean> filterCategory) {
            this.filterCategory = filterCategory;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class DataBean {
            /**
             * id : 1134030
             * name : 简约知性记忆棉坐垫
             * list_pic_url : http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png
             * retail_price : 46
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }

        public static class FilterCategoryBean {
            /**
             * id : 0
             * name : 全部
             * checked : false
             */

            private int id;
            private String name;
            private boolean checked;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }
        }

        public static class GoodsListBean {
            /**
             * id : 1134030
             * name : 简约知性记忆棉坐垫
             * list_pic_url : http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png
             * retail_price : 46
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}

