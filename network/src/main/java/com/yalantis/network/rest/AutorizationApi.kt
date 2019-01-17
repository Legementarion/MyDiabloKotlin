package com.yalantis.network.rest

import com.yalantis.core.models.UserTag
import com.yalantis.core.models.auth.AccessToken
import com.yalantis.core.models.auth.CheckedToken
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