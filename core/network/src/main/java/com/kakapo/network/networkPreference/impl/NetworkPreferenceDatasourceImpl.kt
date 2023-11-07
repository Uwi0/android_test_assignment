package com.kakapo.network.networkPreference.impl

import android.content.Context
import android.content.SharedPreferences
import com.kakapo.network.networkPreference.base.NetworkPreferenceDatasource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkPreferenceDatasourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkPreferenceDatasource {

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    override fun saveStringValue(key: String, value: String) {
        edit {
            putString(key, value)
        }
    }

    override fun getStringValue(key: String): String {
        return preferences.getString(key, "") ?: ""
    }

    private inline fun edit(block: SharedPreferences.Editor.() -> Unit) {
        with(preferences.edit()) {
            block()
            commit()
        }
    }

    companion object {
        private const val PREF_NAME = "VipeNetworkPref"
    }
}