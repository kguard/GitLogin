package com.kguard.data.datasource

import android.util.Log
import com.kguard.data.AccessToken
import com.kguard.data.Repo
import com.kguard.data.User
import retrofit2.Retrofit
import javax.inject.Inject

class TokenDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): TokenDataSource {
    override suspend fun getAccessToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): AccessToken {
        Log.e("===", "getAccessToken: ${clientId}, $clientSecret,$code", )
        val pu =retrofit.create(TokenDataSource::class.java).getAccessToken(clientId,clientSecret,code)
        Log.e("===", "getAccessToken: ${pu.accessToken}", )
        return pu
    }





}