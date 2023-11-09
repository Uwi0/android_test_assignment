package com.kakapo.network.datasource.base

import com.kakapo.network.model.response.PromoResponse

interface PromoApiRemoteDataSource {

    suspend fun requestMessage(): Result<List<PromoResponse>>

}