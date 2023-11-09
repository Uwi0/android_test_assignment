package com.kakapo.network.api

import com.kakapo.network.model.response.PromoResponse
import com.kakapo.network.utils.ApiUrl
import retrofit2.Response
import retrofit2.http.GET

interface PromoApi {

    @GET(ApiUrl.PROMOS)
    suspend fun requestPromos(): Response<List<PromoResponse>>
}