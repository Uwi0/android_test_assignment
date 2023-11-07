package com.kakapo.network.utils

import com.google.gson.Gson
import com.kakapo.network.model.response.ErrorResponse
import retrofit2.Response

suspend fun <T> safeNetworkCall(defaultValue: T, call: suspend () -> Response<T>): Result<T> {
    return try {
        val response = call.invoke()
        val result = if (response.code() == 200) {
            val responseBody = response.body() ?: defaultValue
            Result.success(responseBody)
        } else {
            val errorResponse =
                Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
            val errorMessage = errorResponse?.error?.message ?: "Unknown Error"
            Result.failure(Exception(errorMessage))
        }
        result
    } catch (e: Exception) {
        Result.failure(e)
    }
}