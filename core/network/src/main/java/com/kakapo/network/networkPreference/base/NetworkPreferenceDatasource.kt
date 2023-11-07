package com.kakapo.network.networkPreference.base

interface NetworkPreferenceDatasource {

    fun saveStringValue(key: String, value: String)

    fun getStringValue(key: String): String
}