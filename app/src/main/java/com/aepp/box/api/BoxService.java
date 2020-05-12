package com.aepp.box.api;


import com.aepp.box.models.AeasyLoginModel;
import com.aepp.box.models.NameInfoModel;
import com.aepp.box.models.NamesModel;
import com.aepp.box.models.TxModel;
import com.aepp.box.models.UserInfoModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface BoxService {

    @FormUrlEncoded
    @POST("/api/register")
    Call<AeasyLoginModel> register(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/login")
    Call<AeasyLoginModel> login(@FieldMap Map<String, Object> params);


    @FormUrlEncoded
    @POST("/api/name/auctions")
    Call<NamesModel> apiNameAuctions(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/price")
    Call<NamesModel> apiNamePrice(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/over")
    Call<NamesModel> apiNameOver(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/my/register")
    Call<NamesModel> apiNameMyRegister(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/my/over")
    Call<NamesModel> apiNameMyOver(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/add")
    Call<TxModel> apiNameAdd(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/update")
    Call<TxModel> apiNameUpdate(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/user/info")
    Call<UserInfoModel> apiUserInfo(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("/api/name/info")
    Call<NameInfoModel> apiNameInfo(@FieldMap Map<String, Object> params);


}
