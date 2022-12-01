package com.arthur.android_template.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("result") var result: Result? = Result(),
    @SerializedName("token") var token: String? = null,
    @SerializedName("errors") var errors: ArrayList<String> = arrayListOf(),
    @SerializedName("status") var status: Int? = null
)

data class Result(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email_verified_at") var emailVerifiedAt: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null

)