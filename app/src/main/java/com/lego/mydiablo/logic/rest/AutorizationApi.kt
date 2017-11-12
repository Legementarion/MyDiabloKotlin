package com.lego.mydiablo.logic.rest

import com.lego.mydiablo.logic.rest.models.UserTag
import com.lego.mydiablo.logic.rest.models.auth.AccessToken
import com.lego.mydiablo.logic.rest.models.auth.CheckedToken
import retrofit2.http.*

interface AutorizationApi {

    @FormUrlEncoded
    @POST("/oauth/token")
    fun obtainAccessToken(
            @Field("grant_type") grantType: String,
            @Field("code") code: String,
            @Field("redirect_uri") redirectUri: String,
            @Field("scope") scope: String): AccessToken

    @FormUrlEncoded
    @POST("/oauth/check_token")
    fun checkToken(
            @Field("token") token: String): CheckedToken

    @GET
    fun getTag(
            @Url url: String,
            @Query("access_token") token : String
    ): UserTag
}