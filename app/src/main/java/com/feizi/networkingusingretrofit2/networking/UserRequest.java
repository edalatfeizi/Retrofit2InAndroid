package com.feizi.networkingusingretrofit2.networking;

import com.feizi.networkingusingretrofit2.model.CreateUserResponse;
import com.feizi.networkingusingretrofit2.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Edalat on 2018/09/30.
 */

public interface UserRequest {
    @POST("v2/5bb12a9a2e00005e0092711e")
    Call<CreateUserResponse> sendUserInfo(@Body UserInfo userInfo);

    @GET("v2/5bae71fb2e00005700bb4252")
    Call<UserInfo> getUserInfo(@Query("email") String email);
}
