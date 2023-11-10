package com.kakapo.data

import com.kakapo.data.repository.base.PortfolioRepository
import com.kakapo.data.repository.impl.PortfolioRepositoryImpl
import com.kakapo.network.datasource.impl.FakePortfolioRemoteDatasourceImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertTrue

class PortfolioRepositoryTest {

    @Test
    fun `test find detail item`() = runTest {
        val repository: PortfolioRepository = PortfolioRepositoryImpl(FakePortfolioRemoteDatasourceImpl())
        val request = repository.requestDetailPortfolio("Tarik Tunai").first()
        assertTrue(request.isNotEmpty())
    }
}