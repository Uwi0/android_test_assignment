package com.kakapo.network.model.response

data class ErrorResponse(
    val error: ErrorDetails
)

data class ErrorDetails(
    val message: String,
    val type: String,
    val param: String?,
    val code: String?
)
