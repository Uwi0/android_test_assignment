package com.kakapo.data.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

suspend fun <T> proceed(suspendFun: suspend () -> T): T {
    return try {
        suspendFun.invoke()
    } catch (e: Exception) {
        e.printStackTrace()
        throw e
    }
}

suspend fun <T> proceedResult(suspendFun: suspend () -> Result<T>): T {
    return try {
        val data = suspendFun.invoke()
        if (data.isSuccess) {
            data.getOrThrow()
        } else {
            throw data.exceptionOrNull() ?: Exception()
        }
    } catch (e: Exception) {
        e.printStackTrace()
        throw e
    }
}

suspend fun <T> getDeferredValue(dispatcher: CoroutineDispatcher, function: () -> T): T {
    val callBack = CoroutineScope(dispatcher).async {
        function.invoke()
    }
    return callBack.await()
}


suspend fun <T> getDeferredSuspendValue(
    dispatcher: CoroutineDispatcher,
    function: suspend () -> T
): T {
    val callBack = CoroutineScope(dispatcher).async {
        function.invoke()
    }
    return callBack.await()
}