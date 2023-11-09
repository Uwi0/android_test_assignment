package com.kakapo.network.model.response


import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("data")
    val `data`: Any? = null,
    @SerializedName("error")
    val error: Error? = null
) {
    data class Error(
        @SerializedName("details")
        val details: Details? = null,
        @SerializedName("message")
        val message: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("status")
        val status: Int? = null
    ) {
        class Details
    }
}