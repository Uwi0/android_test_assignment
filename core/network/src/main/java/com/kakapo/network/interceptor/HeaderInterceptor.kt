package com.kakapo.network.interceptor

import com.kakapo.network.networkPreference.PreferenceKey
import com.kakapo.network.networkPreference.base.NetworkPreferenceDatasource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val preference: NetworkPreferenceDatasource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val apiKey = preference.getStringValue(PreferenceKey.GPT_API_KEY)
        val requestBuilder = original.newBuilder()
        requestBuilder.addHeader("Authorization", "Bearer $apiKey")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}