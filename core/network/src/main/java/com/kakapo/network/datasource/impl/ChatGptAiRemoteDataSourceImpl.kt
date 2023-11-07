package com.kakapo.network.datasource.impl

import com.kakapo.network.api.ChatGptApi
import com.kakapo.network.datasource.base.ChatGptAiRemoteDataSource
import com.kakapo.network.model.request.RequestChatCompletions
import com.kakapo.network.model.request.RequestMessages
import com.kakapo.network.model.response.ResponseChatCompletions
import com.kakapo.network.utils.safeNetworkCall
import javax.inject.Inject

class ChatGptAiRemoteDataSourceImpl @Inject constructor(
    private val chatGptApi: ChatGptApi
) : ChatGptAiRemoteDataSource {

    override suspend fun requestMessage(messages: List<RequestMessages>): Result<ResponseChatCompletions> {
        return safeNetworkCall(ResponseChatCompletions()) {
            val requestMessage = RequestChatCompletions(messages = messages)
            chatGptApi.requestMessage(requestMessage)
        }
    }
}