package com.aepp.box.models;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.models
 * @class describe
 * @time 2020-05-07 18:58
 * @change
 * @chang time
 * @class describe
 */
public class AeasyLoginModel {

    /**
     * code : 200
     * msg : success
     * time : 1588849066117
     * data : {"mnemonic":"unusual praise danger slush predict unaware lion typical flock among hammer hawk","redirectUri":"","signingKey":"88ec858c460ea603c33c49e588512f7d8100d945b639f2c8350c2af0020c74cf74b26c81a55102facf271baeccd77904442a107b33627f413bd84f6ec4d34a6f"}
     */

    public int code;
    public String msg;
    public long time;
    public DataBean data;

    public static class DataBean {
        /**
         * mnemonic : unusual praise danger slush predict unaware lion typical flock among hammer hawk
         * redirectUri :
         * signingKey : 88ec858c460ea603c33c49e588512f7d8100d945b639f2c8350c2af0020c74cf74b26c81a55102facf271baeccd77904442a107b33627f413bd84f6ec4d34a6f
         */

        public String mnemonic;
        public String redirectUri;
        public String signingKey;
        public String address;
    }
}
