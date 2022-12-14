package com.kguard.data.datasource

import com.kguard.data.AccessToken
import com.kguard.domain.DomainAccessToken
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
//        val newRequest = request.newBuilder()
//            .addHeader("authorization",// 어떻게 들어가야하나)
//            .build()
        return when (response.code) {
            200 -> response
            400 -> throw NetworkException.BadRequestError("400 ERROR")
            401 -> throw NetworkException.UnauthorizedError("401 ERROR")
            403 -> throw NetworkException.ForbiddenError("403 ERROR")
            404 -> throw NetworkException.NotFoundError("404 ERROR")
            501 -> throw NetworkException.NotImplementedError("501 ERROR")
            502 -> throw NetworkException.BadGatewayError("502 ERROR")
            504 -> throw NetworkException.GatewayTimeoutError("504 ERROR")
            else -> response
        }
       // proceed(newRequest)


    }

}