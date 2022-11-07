package com.arthur.android_template.data.repository.login_repository.local_data_sources

import com.arthur.android_template.data.repository.login_repository.repositorys.LoginLocalDataSource
import com.arthur.android_template.utils.AppPreferences

class LoginRoomLocalDataSource(
    private val pref: AppPreferences
) : LoginLocalDataSource{

    override fun getUserToken(user: String): String? = pref.getUserToken()
}