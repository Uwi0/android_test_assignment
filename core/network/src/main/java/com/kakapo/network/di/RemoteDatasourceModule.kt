package com.kakapo.network.di

import com.kakapo.network.datasource.base.ChatGptAiRemoteDataSource
import com.kakapo.network.datasource.impl.ChatGptAiRemoteDataSourceImpl
import com.kakapo.network.networkPreference.base.NetworkPreferenceDatasource
import com.kakapo.network.networkPreference.impl.NetworkPreferenceDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDatasourceModule {

    @Binds
    fun bindNetworkPreferenceModule(
        preferenceDatasource: NetworkPreferenceDatasourceImpl
    ): NetworkPreferenceDatasource

    @Binds
    fun bindChatGptRemoteDatasource(
        datasource: ChatGptAiRemoteDataSourceImpl
    ): ChatGptAiRemoteDataSource


}