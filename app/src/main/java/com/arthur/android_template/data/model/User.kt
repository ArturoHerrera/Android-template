package com.arthur.android_template.data.model

import com.arthur.android_template.data.local.room.UserEntity

data class User(
    val userEmail: String,
    val userName: String
) {
    constructor(entity: UserEntity): this(
        userEmail = entity.userEmail,
        userName = entity.userName
    )
}
