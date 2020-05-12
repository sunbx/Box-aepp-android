package com.aepp.box.models;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.models
 * @class describe
 * @time 2020-05-09 14:39
 * @change
 * @chang time
 * @class describe
 */
public class UserInfoModel {

    /**
     * code : 200
     * msg : success
     * time : 1589006346945
     * data : {"address":"ak_pcwBT2q3a6m4dTfen8YVnM5qYLd91kyBnn27QHRiiq1L6qy5L","balance":"0"}
     */

    public int code;
    public String msg;
    public long time;
    public DataBean data;

    public static class DataBean {
        /**
         * address : ak_pcwBT2q3a6m4dTfen8YVnM5qYLd91kyBnn27QHRiiq1L6qy5L
         * balance : 0
         */

        public String address;
        public String balance;
    }
}
