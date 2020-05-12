package com.aepp.box.models;

/**
 * @author sunbaixin QQ:283122529
 * @name Box-aepp-Android
 * @class name：com.aepp.box.models
 * @class describe
 * @time 2020-05-09 10:54
 * @change
 * @chang time
 * @class describe
 */
public class TxModel {

    /**
     * code : 200
     * msg : success
     * time : 1588992830169
     * data : {"Tx":{"AccountID":"ak_QyFYYpgJ1vUGk1Lnk8d79WJEVcAtcfuNHqquuP2ADfxsL6yKx","Name":"qwqwqwqwqwqwqwqw.chain","NameSalt":"66458372359044896749812451375306056183218671344097620523949090364676236613609","NameFee":439005000000000000,"Fee":17300000000000,"TTL":253096,"AccountNonce":27},"SignedTx":"tx_+LsLAfhCuECgZSfnoYSHzDm40Uetz2bPNHdYHGbW1aivEcG6vztS0rtLLS1iuXuLV+z1kmgl1V3hEEGAoWSnnoi3jXLICpkKuHP4cSACoQE2bSwv+kIXRTz6B2WSPPRHRenk6O8xIXGFihqAy9oGchuWcXdxd3F3cXdxd3F3cXdxdy5jaGFpbqCS7hsTMD3DyHRa1DejiUv3R+K8ZUF+OkoY5Pcc5eeX6YgGF6i4t57QAIYPu/hayACDA9yoPfWoWg==","Hash":"th_2CzUjUu5SKyNGWGtQkY7iqKn3QWe3jreLnCL8q1Yk7WWHTCgRi","Signature":"sg_Mz62C71vVpFCZSgkjdETCqw8yde6yRNhZBYkMV3PKqpVqpX1Qmqj39YxYNSWyK2iagnz5MMo2WKpWF18woWwza7r84Zn3","BlockHeight":0,"BlockHash":"","Mined":false,"Error":null}
     */

    public int code;
    public String msg;
    public long time;
    public DataBean data;

    public static class DataBean {
        /**
         * Tx : {"AccountID":"ak_QyFYYpgJ1vUGk1Lnk8d79WJEVcAtcfuNHqquuP2ADfxsL6yKx","Name":"qwqwqwqwqwqwqwqw.chain","NameSalt":"66458372359044896749812451375306056183218671344097620523949090364676236613609","NameFee":439005000000000000,"Fee":17300000000000,"TTL":253096,"AccountNonce":27}
         * SignedTx : tx_+LsLAfhCuECgZSfnoYSHzDm40Uetz2bPNHdYHGbW1aivEcG6vztS0rtLLS1iuXuLV+z1kmgl1V3hEEGAoWSnnoi3jXLICpkKuHP4cSACoQE2bSwv+kIXRTz6B2WSPPRHRenk6O8xIXGFihqAy9oGchuWcXdxd3F3cXdxd3F3cXdxdy5jaGFpbqCS7hsTMD3DyHRa1DejiUv3R+K8ZUF+OkoY5Pcc5eeX6YgGF6i4t57QAIYPu/hayACDA9yoPfWoWg==
         * Hash : th_2CzUjUu5SKyNGWGtQkY7iqKn3QWe3jreLnCL8q1Yk7WWHTCgRi
         * Signature : sg_Mz62C71vVpFCZSgkjdETCqw8yde6yRNhZBYkMV3PKqpVqpX1Qmqj39YxYNSWyK2iagnz5MMo2WKpWF18woWwza7r84Zn3
         * BlockHeight : 0
         * BlockHash :
         * Mined : false
         * Error : null
         */

        public TxBean Tx;
        public String SignedTx;
        public String Hash;
        public String Signature;
        public int BlockHeight;
        public String BlockHash;
        public boolean Mined;
        public Object Error;

        public static class TxBean {
            /**
             * AccountID : ak_QyFYYpgJ1vUGk1Lnk8d79WJEVcAtcfuNHqquuP2ADfxsL6yKx
             * Name : qwqwqwqwqwqwqwqw.chain
             * NameSalt : 66458372359044896749812451375306056183218671344097620523949090364676236613609
             * NameFee : 439005000000000000
             * Fee : 17300000000000
             * TTL : 253096
             * AccountNonce : 27
             */

            public String AccountID;
            public String Name;
            public String NameSalt;
            public String NameFee;
            public String Fee;
            public String TTL;
            public String AccountNonce;
        }
    }
}
