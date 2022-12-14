package com.kguard.data.module

import com.kguard.data.BuildConfig
import com.kguard.data.Contents
import com.kguard.data.datasource.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Contents.apiURL)
            .client(provideOkHttpClient(NetworkInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: NetworkInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(3,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }


//    @Provides
//    @Singleton
//    fun provideOkHttpLogging(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            level = if(BuildConfig.DEBUG){
//                HttpLoggingInterceptor.Level.BODY
//            } else {
//                HttpLoggingInterceptor.Level.NONE
//            }
//        }
//    }
}