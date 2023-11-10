package com.kakapo.network.di

import com.kakapo.network.datasource.base.PortfolioRemoteDatasource
import com.kakapo.network.datasource.base.PromoApiRemoteDataSource
import com.kakapo.network.datasource.impl.FakePortfolioRemoteDatasourceImpl
import com.kakapo.network.datasource.impl.PromoApiRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDatasourceModule {

    @Binds
    fun bindPromoRemoteDatasource(
        datasource: PromoApiRemoteDataSourceImpl
    ): PromoApiRemoteDataSource

    @Binds
    fun bindFakePortfolioRemoteDatasource(
        datasource: FakePortfolioRemoteDatasourceImpl
    ): PortfolioRemoteDatasource


}