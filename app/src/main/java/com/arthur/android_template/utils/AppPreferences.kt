package com.arthur.android_template.utils

import android.app.Application
import android.content.Context

class AppPreferences(application: Application) {
    companion object {
        private const val SESSION_TOKEN = "sessionToken"
    }

    private val prefs = application.getSharedPreferences("sharedData", Context.MODE_PRIVATE)

    fun clearAllUserData() {
        val keys = arrayOf(
            SESSION_TOKEN
        )
        keys.onEach { prefs.edit().remove(it).apply() }
    }

    fun setUserToken(userToken: String) = prefs.edit().putString(SESSION_TOKEN, userToken).apply()

    fun getUserToken(): String? = prefs.getString(SESSION_TOKEN, "")
}