package com.arthur.android_template.data.repository.login_repository.repositorys

import com.arthur.android_template.data.model.User
import kotlinx.coroutines.flow.Flow

interface LoginTasks {

    /*
    *   Al tener nuestro manifiesto de tareas,
    *   podemos implementar esta interface en un
    *   repositorio de prueba, para facilitar y promover
    *   el testing.
    */

    suspend fun checkUserSession(
        user: String,
        pass: String
    ): Flow<Boolean>

    suspend fun getUser(): User?

    suspend fun deleteUser()

}