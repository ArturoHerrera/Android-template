package com.arthur.android_template.data.repository.login_repository.repositorys

import com.arthur.android_template.data.model.User
import kotlinx.coroutines.flow.Flow

class LoginFakeRepository(): LoginTasks {


    /*
    *  Este repository es el destinado al testing,
    *  lo usariamos como manifiesto de tareas fake.
    *  Asi toda tarea declarada en LoginTasks seria testeable.
    */

    override suspend fun checkUserSession(user: String, pass: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser() {
        TODO("Not yet implemented")
    }
}