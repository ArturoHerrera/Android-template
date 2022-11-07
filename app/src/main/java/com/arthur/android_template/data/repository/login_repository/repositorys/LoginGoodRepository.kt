package com.arthur.android_template.data.repository.login_repository.repositorys

import com.arthur.android_template.data.remote.dto.AuthResponseDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginGoodRepository(
    loginLocalDS: LoginLocalDataSource,
    private val loginRemoteDS: LoginRemoteDataSource
) : LoginTasks {

    val isValidToken = loginLocalDS.getUserToken("mUserCredentials")

    override suspend fun checkUserSession(
        user: String,
        pass: String
    ): Flow<Boolean> = flow {
        emit(loginRemoteDS.userLogin(user, pass))
    }
        .map { result -> result.succeeded }
        .flowOn(Dispatchers.IO)
        .catch { e -> e.printStackTrace() }

}

interface LoginLocalDataSource {
    fun getUserToken(user: String): String?
}

interface LoginRemoteDataSource {
    suspend fun userLogin(user: String, pass: String): ServiceResult<AuthResponseDto>
}