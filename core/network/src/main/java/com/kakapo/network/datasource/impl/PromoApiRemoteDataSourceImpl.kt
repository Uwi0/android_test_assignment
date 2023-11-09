package com.kakapo.network.datasource.impl

import com.kakapo.network.api.PromoApi
import com.kakapo.network.datasource.base.PromoApiRemoteDataSource
import com.kakapo.network.model.response.PromoResponse
import com.kakapo.network.utils.safeNetworkCall
import javax.inject.Inject

class PromoApiRemoteDataSourceImpl @Inject constructor(
    private val promoApi: PromoApi
) : PromoApiRemoteDataSource {

    override suspend fun requestMessage(): Result<List<PromoResponse>> = safeNetworkCall(emptyList()){
        promoApi.requestPromos()
    }
}