package com.kakapo.network.model.response


import com.google.gson.annotations.SerializedName

data class ResponseChatCompletions(
    @SerializedName("choices")
    var choices: List<Choice?>? = listOf(),
    @SerializedName("created")
    var created: Int? = 0,
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("model")
    var model: String? = "",
    @SerializedName("object")
    var objectX: String? = "",
    @SerializedName("usage")
    var usage: Usage? = Usage()
) {
    data class Choice(
        @SerializedName("finish_reason")
        var finishReason: String? = "",
        @SerializedName("index")
        var index: Int? = 0,
        @SerializedName("message")
        var message: Message? = Message()
    ) {
        data class Message(
            @SerializedName("content")
            var content: String? = "",
            @SerializedName("role")
            var role: String? = ""
        )
    }

    data class Usage(
        @SerializedName("completion_tokens")
        var completionTokens: Int? = 0,
        @SerializedName("prompt_tokens")
        var promptTokens: Int? = 0,
        @SerializedName("total_tokens")
        var totalTokens: Int? = 0
    )
}