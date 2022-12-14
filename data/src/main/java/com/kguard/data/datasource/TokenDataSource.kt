package com.kguard.data.datasource

import com.kguard.data.AccessToken
import com.kguard.data.Contents
import retrofit2.http.*

interface TokenDataSource {
    @Headers("Accept: application/json")
    @POST(Contents.domainURL + "login/oauth/access_token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String,
        //@FieldMap
    ): AccessToken
}