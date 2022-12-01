package com.arthur.android_template.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.arthur.android_template.data.remote.dto.AuthResponseDto

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = "user_email") val userEmail: String,
    @ColumnInfo(name = "user_name") val userName: String
) {

    @Ignore
    constructor(dto: AuthResponseDto?): this(
        dto?.result?.email ?: "",
        dto?.result?.name ?: "--",
    )
}
