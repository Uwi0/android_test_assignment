package com.kakapo.network

import arrow.core.flatMap
import com.kakapo.network.datasource.base.PortfolioRemoteDatasource
import com.kakapo.network.datasource.impl.FakePortfolioRemoteDatasourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FakePortfolioRemoteDatasourceTest {
    @Test
    fun `test if fake function already work`() = runTest {
        val datasource: PortfolioRemoteDatasource = FakePortfolioRemoteDatasourceImpl()
        val portfolio = datasource.requestPortfolio().getOrThrow()
        val firstValue = portfolio.first().type
        assertEquals(firstValue, "donutChart")
    }
}