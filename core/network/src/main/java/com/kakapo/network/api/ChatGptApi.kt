package com.kakapo.network.api

import com.kakapo.network.model.request.RequestChatCompletions
import com.kakapo.network.model.response.ResponseChatCompletions
import com.kakapo.network.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatGptApi {

    @POST(ApiConstants.TextCompletionsEndpoint)
    suspend fun requestMessage(@Body requestBody: RequestChatCompletions): Response<ResponseChatCompletions>

}