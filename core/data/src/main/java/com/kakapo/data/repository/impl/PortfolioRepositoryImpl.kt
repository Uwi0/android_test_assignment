package com.kakapo.data.repository.impl

import com.kakapo.data.model.toPortfolioDetailItem
import com.kakapo.data.model.toPortfolioItem
import com.kakapo.data.repository.base.PortfolioRepository
import com.kakapo.data.util.proceed
import com.kakapo.data.util.proceedResult
import com.kakapo.model.PortfolioDetailItem
import com.kakapo.model.PortfolioItem
import com.kakapo.network.datasource.base.PortfolioRemoteDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(
    private val portfolioRemoteDatasource: PortfolioRemoteDatasource
): PortfolioRepository {
    override fun requestPortfolios(): Flow<List<PortfolioItem>> = flow {
        val result = proceedResult { portfolioRemoteDatasource.requestPortfolio() }
        val portfolioResponse = proceed { result.flatMap { it.data } }
        emit(portfolioResponse.map(::toPortfolioItem))
    }

    override fun requestDetailPortfolio(label: String): Flow<List<PortfolioDetailItem>> = flow {
        val result = proceedResult { portfolioRemoteDatasource.requestPortfolio() }
        val portfolioResponse = proceed { result.flatMap { it.data } }
            .filter { it.label.equals(label, ignoreCase = true) }
            .flatMap { it.data }
        emit(portfolioResponse.map(::toPortfolioDetailItem))
    }
}