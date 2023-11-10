package com.kakapo.data.di

import com.kakapo.data.repository.base.PortfolioRepository
import com.kakapo.data.repository.base.PromoRepository
import com.kakapo.data.repository.impl.PortfolioRepositoryImpl
import com.kakapo.data.repository.impl.PromoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPromoRepository(
        repository: PromoRepositoryImpl
    ): PromoRepository

    @Binds
    fun bindPortfolioRepository(
        repository: PortfolioRepositoryImpl
    ): PortfolioRepository
}