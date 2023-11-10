package com.kakapo.network.datasource.base

import com.kakapo.network.model.response.PortfolioResponse

interface PortfolioRemoteDatasource {

    suspend fun requestPortfolio(): Result<List<PortfolioResponse>>
}