package com.kakapo.network.datasource.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kakapo.network.datasource.base.PortfolioRemoteDatasource
import com.kakapo.network.model.response.PortfolioResponse
import javax.inject.Inject

class FakePortfolioRemoteDatasourceImpl @Inject constructor(): PortfolioRemoteDatasource {
    override suspend fun requestPortfolio(): Result<List<PortfolioResponse>> {
        val gson = Gson()
        val type = object: TypeToken<List<PortfolioResponse>>(){}.type
        val response = gson.fromJson<List<PortfolioResponse>>(FAKE_RESPONSE, type)
        return Result.success(response)
    }

    companion object{
        const val FAKE_RESPONSE = """
            [{
		"type": "donutChart",
		"data": [{
				"label": "Tarik Tunai",
				"percentage": "55",
				"data": [{
					"trx_date": "21/01/2023",
					"nominal": 1000000
				}, {
					"trx_date": "20/01/2023",
					"nominal": 500000
				}, {
					"trx_date": "19/01/2023",
					"nominal": 1000000
				}]
			},
			{
				"label": "QRIS Payment",
				"percentage": "31",
				"data": [{
					"trx_date": "21/01/2023",
					"nominal": 159000
				}, {
					"trx_date": "20/01/2023",
					"nominal": 35000
				}, {
					"trx_date": "19/01/2023",
					"nominal": 1500
				}]
			},
			{
				"label": "Topup Gopay",
				"percentage": "7.7",
				"data": [{
					"trx_date": "21/01/2023",
					"nominal": 200000
				}, {
					"trx_date": "20/01/2023",
					"nominal": 195000
				}, {
					"trx_date": "19/01/2023",
					"nominal": 5000000
				}]
			},
			{
				"label": "Lainnya",
				"percentage": "6.3",
				"data": [{
					"trx_date": "21/01/2023",
					"nominal": 1000000
				}, {
					"trx_date": "20/01/2023",
					"nominal": 500000
				}, {
					"trx_date": "19/01/2023",
					"nominal": 1000000
				}]
			}
		]
	}
]
        """
    }
}