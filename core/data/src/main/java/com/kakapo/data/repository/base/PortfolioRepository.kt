package com.kakapo.data.repository.base

import com.kakapo.model.PortfolioDetailItem
import com.kakapo.model.PortfolioItem
import kotlinx.coroutines.flow.Flow

interface PortfolioRepository {

    fun requestPortfolios(): Flow<List<PortfolioItem>>

    fun requestDetailPortfolio(label: String): Flow<List<PortfolioDetailItem>>
}