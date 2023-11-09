package com.kakapo.network.di

import com.kakapo.network.api.PromoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun providesChatGpt(builder: Retrofit.Builder): PromoApi{
        return builder.build().create(PromoApi::class.java)
    }

}