package com.kakapo.network.datasource.base

import com.kakapo.network.model.request.RequestMessages
import com.kakapo.network.model.response.ResponseChatCompletions

interface ChatGptAiRemoteDataSource {

    suspend fun requestMessage(messages: List<RequestMessages>): Result<ResponseChatCompletions>

}