package com.arthur.android_template.data.remote.api

import com.arthur.android_template.data.remote.dto.AuthResponseDto
import com.arthur.android_template.data.remote.dto.LoginBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    /*
    *  Endpoint tomado de: https://apingweb.com/
    */

    @POST("/api/login")
    suspend fun userLogin(
        @Body body: LoginBody
    ): Response<AuthResponseDto>

}