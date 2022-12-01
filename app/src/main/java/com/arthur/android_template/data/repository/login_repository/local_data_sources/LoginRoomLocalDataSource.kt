package com.arthur.android_template.data.repository.login_repository.local_data_sources

import com.arthur.android_template.core.AppPreferences
import com.arthur.android_template.data.local.room.UserDao
import com.arthur.android_template.data.local.room.UserEntity
import com.arthur.android_template.data.model.User
import com.arthur.android_template.data.remote.dto.AuthResponseDto
import com.arthur.android_template.data.repository.login_repository.repositorys.LoginLocalDataSource
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LoginRoomLocalDataSource(
    private val pref: AppPreferences,
    private val dao: UserDao
) : LoginLocalDataSource {

    override fun getUserToken(user: String): String? = pref.getUserToken()

    override suspend fun setUser(userDto: AuthResponseDto): User? {
        val entity = UserEntity(userDto)
        dao.insertUser(entity)
        return User(entity)
    }

    override suspend fun getUser(): User? = dao
        .getUser()
        .map { entity -> entity?.let { User(it) } }
        .filterNotNull()
        .first()

    override suspend fun deleteUser() = dao
        .deleteUser()
}