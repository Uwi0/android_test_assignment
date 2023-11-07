package com.kakapo.network.di

import com.kakapo.network.interceptor.HeaderInterceptor
import com.kakapo.network.interceptor.LoggingInterceptor
import com.kakapo.network.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.co.jarvis.logger.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(loggingInterceptor)
        val loggingLevelBody = HttpLoggingInterceptor.Level.BODY
        val loggingLevelNone = HttpLoggingInterceptor.Level.NONE
        interceptor.level = if (BuildConfig.DEBUG) loggingLevelBody else loggingLevelNone
        return interceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        headerInterceptor: HeaderInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headerInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BaseUrlOpenAI)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
    }

}

