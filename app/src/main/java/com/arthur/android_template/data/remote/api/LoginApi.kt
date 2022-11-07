package com.arthur.android_template.data.remote.api

import com.arthur.android_template.data.remote.dto.AuthResponseDto
import retrofit2.Response
import retrofit2.http.POST

interface LoginApi {

    @POST("/login-auth")
    suspend fun userLogin(
    ): Response<AuthResponseDto>

}