package com.kakapo.network.model.request

data class RequestChatCompletions(
    val model: String = "gpt-3.5-turbo",
    val messages: List<RequestMessages>
)

data class RequestMessages(
    val role: String,
    val content: String
)
