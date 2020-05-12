package com.aepp.box.models;

import java.util.List;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.models
 * @class describe
 * @time 2020-05-09 14:25
 * @change
 * @chang time
 * @class describe
 */
public class NameInfoModel {

    /**
     * code : 200
     * msg : success
     * time : 1588996878838
     * data : {"claim":[{"account_id":"ak_2pqYSBpEkykFy11KFZXxDJaB8KugXBi2JxraqZXpTaXzreYb95","fee":16320000000000,"name":"j.chain","name_fee":"599.00000","name_salt":0,"nonce":29,"type":"NameClaimTx","version":2},{"account_id":"ak_2aFdJCak4gQ5Gj1ULRC1FDWvmq7a73CS74RxF7VdtnwFRoGFKw","fee":16460000000000,"name":"J.chain","name_fee":"570.28870","name_salt":3722695316291950,"nonce":35,"type":"NameClaimTx","version":2}],"current_height":252617,"current_price":"599.00000","end_height":210812,"length":1,"name":"j.chain","over_height":301393,"owner":"ak_QyFYYpgJ1vUGk1Lnk8d79WJEVcAtcfuNHqquuP2ADfxsL6yKx","start_height":181052,"th_hash":"th_2FMasjNXuFcyNjEVxSHAC7xx4EWwokcJ6GYitC3sj5rLaS4WRY"}
     */

    public int code;
    public String msg;
    public long time;
    public DataBean data;

    public static class DataBean {
        /**
         * claim : [{"account_id":"ak_2pqYSBpEkykFy11KFZXxDJaB8KugXBi2JxraqZXpTaXzreYb95","fee":16320000000000,"name":"j.chain","name_fee":"599.00000","name_salt":0,"nonce":29,"type":"NameClaimTx","version":2},{"account_id":"ak_2aFdJCak4gQ5Gj1ULRC1FDWvmq7a73CS74RxF7VdtnwFRoGFKw","fee":16460000000000,"name":"J.chain","name_fee":"570.28870","name_salt":3722695316291950,"nonce":35,"type":"NameClaimTx","version":2}]
         * current_height : 252617
         * current_price : 599.00000
         * end_height : 210812
         * length : 1
         * name : j.chain
         * over_height : 301393
         * owner : ak_QyFYYpgJ1vUGk1Lnk8d79WJEVcAtcfuNHqquuP2ADfxsL6yKx
         * start_height : 181052
         * th_hash : th_2FMasjNXuFcyNjEVxSHAC7xx4EWwokcJ6GYitC3sj5rLaS4WRY
         */

        public int current_height;
        public String current_price;
        public int end_height;
        public int length;
        public String name;
        public int over_height;
        public String owner;
        public int start_height;
        public String th_hash;
        public List<ClaimBean> claim;

        public static class ClaimBean {
            /**
             * account_id : ak_2pqYSBpEkykFy11KFZXxDJaB8KugXBi2JxraqZXpTaXzreYb95
             * fee : 16320000000000
             * name : j.chain
             * name_fee : 599.00000
             * name_salt : 0
             * nonce : 29
             * type : NameClaimTx
             * version : 2
             */

            public String account_id;
            public String fee;
            public String name;
            public String name_fee;
            public String name_salt;
            public String nonce;
            public String type;
            public int version;
        }
    }
}
