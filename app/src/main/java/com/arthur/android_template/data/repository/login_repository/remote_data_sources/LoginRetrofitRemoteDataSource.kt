package com.arthur.android_template.data.repository.login_repository.remote_data_sources

import com.arthur.android_template.data.remote.api.LoginApi
import com.arthur.android_template.data.remote.dto.AuthResponseDto
import com.arthur.android_template.data.repository.login_repository.repositorys.LoginRemoteDataSource
import com.arthur.android_template.utils.networkCall
import com.arthur.meal_db.utils.ServiceResult

class LoginRetrofitRemoteDataSource(
    private val loginApi: LoginApi
) : LoginRemoteDataSource {


    override suspend fun userLogin(user: String, pass: String): ServiceResult<AuthResponseDto> =
        networkCall {
            loginApi.userLogin().body()!!
        }
}