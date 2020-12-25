package com.example.item.bean;

import java.util.List;

public class NeteaseBean {

    /**
     * info : {"_postman_id":"39b6de3d-21f0-4cce-ab2d-7b6e677d6dd5","name":"商场","description":"商场api","schema":"https://schema.getpostman.com/json/collection/v2.0.0/collection.json"}
     * item : [{"name":"首页","_postman_id":"4aca20ea-546e-4aa0-beb9-1a3fb10fec60","request":{"method":"GET","header":[],"url":"https://cdwan.cn/api/index"},"response":[]},{"name":"专题","_postman_id":"edba2aaf-61f2-4204-b80d-7b67a8229252","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/topic/list?page=1&size=10","protocol":"https","host":["cdwan","cn"],"path":["api","topic","list"],"query":[{"key":"page","value":"1"},{"key":"size","value":"10"}]}},"response":[]},{"name":"分类竖着导航","_postman_id":"d9e6db61-943c-424a-aecb-d2875181b8dc","request":{"method":"GET","header":[],"url":"https://cdwan.cn/api/catalog/index","description":"请求分类竖导航数据接口\n数据里面的currentCategory数据对应右边的网格布局里面的数据内容"},"response":[]},{"name":"分类右边对应的当前分类的数据","_postman_id":"29803805-6740-4f7b-9857-e22f0d959e70","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/catalog/current?id=1005001","protocol":"https","host":["cdwan","cn"],"path":["api","catalog","current"],"query":[{"key":"id","value":"1005001"}]},"description":"用来请求当前分类的列表数据"},"response":[]},{"name":"商品详情列表数据","_postman_id":"8299d62a-afc8-49b1-872d-3976a3516d12","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/list?categoryId=1005007&page=1&size=100","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"categoryId","value":"1005007"},{"key":"page","value":"1"},{"key":"size","value":"100"}]},"description":"点击商品分类右边列表中的商品，打开商品详情页"},"response":[]},{"name":"商品分类的顶部导航数据接口","_postman_id":"33bfd5cf-2b85-439e-80ad-ace49d9667ce","request":{"method":"GET","header":[],"url":{"raw":"http://cdwan.cn/goods/category?id=1005007","protocol":"http","host":["cdwan","cn"],"path":["goods","category"],"query":[{"key":"id","value":"1005007"}]}},"response":[]},{"name":"获取当前分类的列表数据","_postman_id":"e23c840f-41bc-4ec2-ba62-90d1b6114010","protocolProfileBehavior":{"disableBodyPruning":true},"request":{"method":"GET","header":[{"key":"Content-Type","name":"Content-Type","value":"application/x-www-form-urlencoded","type":"text"},{"key":"Accept-Encoding","value":"utf-8","type":"text"}],"body":{"mode":"raw","raw":"<xml>\n    <appid>wx0dc7c1fa36761c64<\/appid>\n    <attach>支付测试<\/attach>\n    <body>![CDATA[App支付测试]]<\/body>\n    <mch_id>1299369201<\/mch_id>\n    <notify_url>http://cdwan.cn:8080/wxpayreturn<\/notify_url>\n    <out_trade_no>2020291857AXP14T<\/out_trade_no>\n    <total_fee>1<\/total_fee>\n    <spbill_create_ip>39.96.0.38<\/spbill_create_ip>\n    <trade_type>APP<\/trade_type>\n    <sign>522FDDE2BD60AB5438EB1DD09B75E1D0C3A9257C55205657BA59337E4097BBEA<\/sign>\n<\/xml>"},"url":{"raw":"https://cdwan.cn/api/goods/list?id=1005008&page=1&size=100","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"id","value":"1005008"},{"key":"page","value":"1"},{"key":"size","value":"100"}]}},"response":[]},{"name":"制造商品牌列表","_postman_id":"0de3f378-f1d6-4aea-9122-26c9f3655998","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/brand/list?page=1&size=1000","protocol":"https","host":["cdwan","cn"],"path":["api","brand","list"],"query":[{"key":"page","value":"1","description":"当前的页码"},{"key":"size","value":"1000","description":"每页的数量"}]}},"response":[]},{"name":"制造商详情页面数据接口","_postman_id":"04b0d0a2-e595-4517-a5d0-4e61d351eeeb","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/brand/detail?id=1001000","protocol":"https","host":["cdwan","cn"],"path":["api","brand","detail"],"query":[{"key":"id","value":"1001000"}]}},"response":[]},{"name":"制造商详情页商品列表的数据接口","_postman_id":"19c3d8a4-e759-4b09-8805-a5598afd3840","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/list?brandId=1001000&page=1&size=1000","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"brandId","value":"1001000"},{"key":"page","value":"1"},{"key":"size","value":"1000"}]}},"response":[]},{"name":"新品，居家等分类人气推荐详情页接口","_postman_id":"1e123c99-4f5b-4f22-915a-620c04544276","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/related?id=1116011","protocol":"https","host":["cdwan","cn"],"path":["api","goods","related"],"query":[{"key":"id","value":"1116011"}]}},"response":[]},{"name":"新品页面商品顶部热门商品信息","_postman_id":"7de2a90d-9a8e-4bba-82f3-271443fd81aa","request":{"method":"GET","header":[],"url":"https://cdwan.cn/api/goods/hot","description":"新品商品的顶部热门商品信息"},"response":[]},{"name":"新品页面商品列表数据","_postman_id":"9b3e882e-34db-4ab8-9922-fc585892cdce","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"isNew","value":"1","description":"是否是新品 0否 1是"},{"key":"page","value":"1","description":"当前的页码"},{"key":"size ","value":"1000","description":"每页的数量"},{"key":"order","value":"asc","description":"asc升序 desc降序"},{"key":"sort","value":"default","description":"default默认 price价格 category类别"},{"key":"categoryId","value":"0","description":"类别Id 全部 居家 餐厨 婴童 杂货 饮食(每个分类里对应的ID)"}]}},"response":[]},{"name":"人气推荐页面","_postman_id":"ea4d4db3-75fe-46a1-9a1d-289012501528","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/list?isHot=1&page=1&size =1000&order=desc&sort=category&categoryId=1008000","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"isHot","value":"1","description":"是否热门 0否 1是"},{"key":"page","value":"1"},{"key":"size ","value":"1000"},{"key":"order","value":"desc","description":"asc升序 desc降序"},{"key":"sort","value":"category","description":"default默认 price价格 category类别"},{"key":"categoryId","value":"1008000","description":"全部 居家 配件 饮食 志趣 （每种分类对应的有一个ID）"}]}},"response":[]},{"name":"专题列表数据","_postman_id":"eb7c9bfb-3187-4859-8790-58525d29ca05","request":{"method":"GET","header":[],"url":"https://cdwan.cn/api/topic/list"},"response":[]},{"name":"专题详情数据","_postman_id":"b4e6d7e6-0e3d-41d8-a067-59b7ff045f23","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/topic/detail?id=314","protocol":"https","host":["cdwan","cn"],"path":["api","topic","detail"],"query":[{"key":"id","value":"314","description":"专题ID"}]}},"response":[]},{"name":"专题详情页相关的专题推荐数据","_postman_id":"bbc1ac4a-04ee-4df5-9188-c864fe30ee95","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/topic/related?id=314","protocol":"https","host":["cdwan","cn"],"path":["api","topic","related"],"query":[{"key":"id","value":"314","description":"专题ID"}]}},"response":[]},{"name":"专题详情页评论数据","_postman_id":"9dc230d1-ad71-4d04-bb23-b92d458c3f0c","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/comment/list?valueId=314&typeId=1&size=5","protocol":"https","host":["cdwan","cn"],"path":["api","comment","list"],"query":[{"key":"valueId","value":"314","description":"非必须  专题数据的ID"},{"key":"typeId","value":"1","description":"1专题数据"},{"key":"size","value":"5","description":"获取的数量"}]}},"response":[]},{"name":"评论的总数","_postman_id":"69ff2397-4ef3-4ec2-9ac7-71b55f5569a7","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/comment/count?valueId=314&typeId=1","protocol":"https","host":["cdwan","cn"],"path":["api","comment","count"],"query":[{"key":"valueId","value":"314"},{"key":"typeId","value":"1"},{"key":"","value":"","disabled":true}]}},"response":[]},{"name":"商品评论","_postman_id":"c316619a-ef90-4b88-84d9-e91996231d0f","request":{"method":"POST","header":[],"body":{"mode":"formdata","formdata":[{"key":"typeId","value":"1","description":"类别1","type":"text"},{"key":"valueId","value":"314","description":"商品ID","type":"text"},{"key":"content","value":"评论内容","type":"text"}]},"url":{"raw":"https://cdwan.cn/api/comment/post","protocol":"https","host":["cdwan","cn"],"path":["api","comment","post"],"query":[{"key":"valueId","value":"314","disabled":true},{"key":"typeId","value":"1","disabled":true}]}},"response":[]},{"name":"商品购买详情页","_postman_id":"b173804d-2cc9-4150-bc38-1f13239b1f0a","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/detail?id=1155000","protocol":"https","host":["cdwan","cn"],"path":["api","goods","detail"],"query":[{"key":"id","value":"1155000"}]}},"response":[]},{"name":"商品购买详情页底部商品列表数据","_postman_id":"d8f3eb6f-e13b-417d-bbc7-c638adee03ae","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/related?id=1155000","protocol":"https","host":["cdwan","cn"],"path":["api","goods","related"],"query":[{"key":"id","value":"1155000"}]}},"response":[]},{"name":"获取购物车数据","_postman_id":"40d01fd4-6cc7-4e33-83f4-15b7584282c8","request":{"method":"GET","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxMTA3MDh9.jfCRTkgEVWwFKTFhvRq8wDMj4-5HeKh2P9dDFcj5I0I","type":"text"}],"url":"https://cdwan.cn/api/cart/index"},"response":[]},{"name":"登录接口","_postman_id":"5d8d8fbb-5d81-4f95-af83-9ab64400c0ee","request":{"method":"POST","header":[{"key":"nickname","value":"q123","type":"text","disabled":true},{"key":"password","value":"123456","type":"text","disabled":true}],"body":{"mode":"formdata","formdata":[{"key":"username","value":"z1234","type":"text"},{"key":"password","value":"123456","type":"text"}]},"url":"https://cdwan.cn/api/auth/login"},"response":[]},{"name":"注册接口","_postman_id":"4856fd1c-1413-4068-ba34-5093f7edcb1d","request":{"method":"POST","header":[{"key":"Client-Type","value":"ANDROID","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"nickname","value":"w123","type":"text"},{"key":"password","value":"111111","type":"text"},{"key":"verify","value":"1111","type":"text","disabled":true}]},"url":"https://cdwan.cn/api/auth/register"},"response":[]},{"name":"商品总数","_postman_id":"a7636342-4538-4c87-bb03-9f8b71863619","request":{"method":"GET","header":[],"url":"https://cdwan.cn/api/goods/count"},"response":[]},{"name":"添加到购物车","_postman_id":"e0d47e53-31ef-40e1-b7df-19256cbfd119","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"goodsId","value":"1116033","type":"text"},{"key":"number","value":"1","type":"text"},{"key":"productId","value":"171","description":"商品购买页面这个接口goods/detail获取到的productList这个数据里面的ID","type":"text"}]},"url":"https://cdwan.cn/api/cart/add"},"response":[]},{"name":"商品更新","_postman_id":"f8369cca-a629-4a4f-987c-5ca23cda2932","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"productId","value":"15","type":"text"},{"key":"goodsId","value":"1009013","type":"text"},{"key":"number","value":"3","type":"text"},{"key":"id","value":"106","type":"text"}]},"url":"https://cdwan.cn/api/cart/update","description":"购物车商品数量更新"},"response":[]},{"name":"删除购物车商品","_postman_id":"bb48f7a7-6146-4046-9131-f4b267bf2a8f","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"productIds","value":"171","description":"多个商品删除，id用逗号隔开","type":"text"}]},"url":"https://cdwan.cn/api/cart/delete"},"response":[]},{"name":"商品选择","_postman_id":"d7b0cd9c-7423-4981-b177-31e89f8b1e3d","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"},{"key":"Client-Type","value":"ANDROID","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"productIds","value":"228","description":"多个商品id以逗号隔开","type":"text"},{"key":"isChecked","value":"0","description":"选中为0 ，非选 1","type":"text"}]},"url":"https://cdwan.cn/api/cart/checked","description":"商品选择"},"response":[]},{"name":"提交订单","_postman_id":"e67948e7-795f-4ba3-be9d-0bef75fe9d26","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"addressId","value":"1","description":"地址ID","type":"text"},{"key":"couponId","value":"1","description":"优惠券ID","type":"text"}]},"url":"https://cdwan.cn/api/cart/submit"},"response":[]},{"name":"下单前信息确认","_postman_id":"845ea146-e1a4-4717-8a8b-9f9f0553973b","request":{"method":"GET","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"url":{"raw":"https://cdwan.cn/api/cart/checkout?addressId=1&couponId=1","protocol":"https","host":["cdwan","cn"],"path":["api","cart","checkout"],"query":[{"key":"addressId","value":"1","description":"地址ID"},{"key":"couponId","value":"1","description":"优惠券"}]}},"response":[]},{"name":"收货地址列表","_postman_id":"9a3cea91-135f-4a53-809e-427e7716b429","request":{"method":"GET","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"url":"https://cdwan.cn/api/address/list"},"response":[]},{"name":"地址详情信息","_postman_id":"569052d9-0524-4190-8d05-9713985cdcd5","request":{"method":"GET","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"url":{"raw":"https://cdwan.cn/api/address/detail?id=1","protocol":"https","host":["cdwan","cn"],"path":["api","address","detail"],"query":[{"key":"id","value":"1","description":"地址ID"}]}},"response":[]},{"name":"添加地址","_postman_id":"0ea82e93-cf2f-4c66-bbbc-49150919da1c","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"id","value":"1","description":"地址ID","type":"text"},{"key":"name","value":"北京","description":"地址名","type":"text"},{"key":"mobile","value":"13000000000","description":"电话","type":"text"},{"key":"province_id","value":"1","description":"省份ID","type":"text"},{"key":"city_id","value":"1","description":"城市ID","type":"text"},{"key":"district_id","value":"1","description":"街道ID","type":"text"},{"key":"address","value":"xxx","description":"地址信息","type":"text"},{"key":"is_default","value":"0","description":"0默认 ","type":"text"}]},"url":"https://cdwan.cn/api/address/save"},"response":[]},{"name":"删除地址","_postman_id":"7af0f09d-b85d-426f-b8bc-85831eb60a2e","request":{"method":"POST","header":[{"key":"X-Nideshop-Token","value":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMxNjgzMDB9.aqdQNPdW8anMSqaqfAGWNPZxbb6j39tAaV-fOuzNhUM","type":"text"}],"body":{"mode":"formdata","formdata":[{"key":"id","value":"1","description":"地址ID","type":"text"}]},"url":"https://cdwan.cn/api/address/delete"},"response":[]},{"name":"获取省市区的数据","_postman_id":"68629bdb-aa75-4027-8885-21254c53129c","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/region/list?parentId=1","protocol":"https","host":["cdwan","cn"],"path":["api","region","list"],"query":[{"key":"parentId","value":"1","description":"对应省，市，区的ID"}]}},"response":[]},{"name":"搜索页面的初始化数据接口","_postman_id":"05639d75-b3dc-49af-8e00-7f80518f9fda","request":{"method":"GET","header":[{"key":"Content-Type","name":"Content-Type","value":"application/json","type":"text","disabled":true}],"url":"https://cdwan.cn/api/search/index"},"response":[]},{"name":"获取搜索条件","_postman_id":"68f8234e-ac99-4d80-ac42-f3dd49888fb5","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/search/helper?keyword=母亲","protocol":"https","host":["cdwan","cn"],"path":["api","search","helper"],"query":[{"key":"keyword","value":"母亲"}]}},"response":[]},{"name":"搜索获取商品接口","_postman_id":"98e177f0-e3db-44e9-9841-7bc03e14657f","request":{"method":"GET","header":[],"url":{"raw":"https://cdwan.cn/api/goods/list?keyword=墨镜&page=1&size=100&sort=default&order=desc&categoryId=0","protocol":"https","host":["cdwan","cn"],"path":["api","goods","list"],"query":[{"key":"keyword","value":"墨镜","description":"搜索关键字\n"},{"key":"page","value":"1","description":"当前的页面"},{"key":"size","value":"100","description":"每页的数量"},{"key":"sort","value":"default","description":"排序类别（default:综合排序，price:价格排序）"},{"key":"order","value":"desc","description":"desc:降序，asc:升序"},{"key":"categoryId","value":"0","description":"categoryId"}]}},"response":[]},{"name":"搜索清理","_postman_id":"7da3f456-d021-4b78-a665-0b53baf7e976","request":{"method":"POST","header":[],"url":"https://cdwan.cn/api/search/clearhistory"},"response":[]}]
     */

    private InfoBean info;
    private List<ItemBean> item;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class InfoBean {
        /**
         * _postman_id : 39b6de3d-21f0-4cce-ab2d-7b6e677d6dd5
         * name : 商场
         * description : 商场api
         * schema : https://schema.getpostman.com/json/collection/v2.0.0/collection.json
         */

        private String _postman_id;
        private String name;
        private String description;
        private String schema;

        public String get_postman_id() {
            return _postman_id;
        }

        public void set_postman_id(String _postman_id) {
            this._postman_id = _postman_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }
    }

    public static class ItemBean {
        /**
         * name : 首页
         * _postman_id : 4aca20ea-546e-4aa0-beb9-1a3fb10fec60
         * request : {"method":"GET","header":[],"url":"https://cdwan.cn/api/index"}
         * response : []
         * protocolProfileBehavior : {"disableBodyPruning":true}
         */

        private String name;
        private String _postman_id;
        private RequestBean request;
        private ProtocolProfileBehaviorBean protocolProfileBehavior;
        private List<?> response;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String get_postman_id() {
            return _postman_id;
        }

        public void set_postman_id(String _postman_id) {
            this._postman_id = _postman_id;
        }

        public RequestBean getRequest() {
            return request;
        }

        public void setRequest(RequestBean request) {
            this.request = request;
        }

        public ProtocolProfileBehaviorBean getProtocolProfileBehavior() {
            return protocolProfileBehavior;
        }

        public void setProtocolProfileBehavior(ProtocolProfileBehaviorBean protocolProfileBehavior) {
            this.protocolProfileBehavior = protocolProfileBehavior;
        }

        public List<?> getResponse() {
            return response;
        }

        public void setResponse(List<?> response) {
            this.response = response;
        }

        public static class RequestBean {
            /**
             * method : GET
             * header : []
             * url : https://cdwan.cn/api/index
             */

            private String method;
            private String url;
            private List<?> header;

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<?> getHeader() {
                return header;
            }

            public void setHeader(List<?> header) {
                this.header = header;
            }
        }

        public static class ProtocolProfileBehaviorBean {
            /**
             * disableBodyPruning : true
             */

            private boolean disableBodyPruning;

            public boolean isDisableBodyPruning() {
                return disableBodyPruning;
            }

            public void setDisableBodyPruning(boolean disableBodyPruning) {
                this.disableBodyPruning = disableBodyPruning;
            }
        }
    }
}

