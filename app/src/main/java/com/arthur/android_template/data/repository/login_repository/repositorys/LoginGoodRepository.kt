package com.arthur.android_template.data.repository.login_repository.repositorys

import com.arthur.android_template.data.model.User
import com.arthur.android_template.data.remote.dto.AuthResponseDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.getDto
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginGoodRepository(
    private val loginLocalDS: LoginLocalDataSource,
    private val loginRemoteDS: LoginRemoteDataSource
) : LoginTasks {

    val isValidToken = loginLocalDS.getUserToken("mUserCredentials")

    override suspend fun checkUserSession(
        user: String,
        pass: String
    ): Flow<Boolean> = flow {
        emit(loginRemoteDS.userLogin(user, pass))
    }
        .map { result ->
            if (result.succeeded) {
                /*
                *  Si desearamos obtener la información del usuario insertado,
                *  cambiariamos la firma de esta suspend function (Desde las LoginTasks) .
                *
                *  Para este caso de muestra, tampoco valideraemos la
                *  nullabilidad de los datos, pero seria lo correcto.
                */
                val mUserDto = result.getDto()
                mUserDto?.let { safeAuthDto ->
                    loginLocalDS.setUser(safeAuthDto)
                }
                return@map mUserDto?.success ?: false
            }
            return@map false
        }
        .flowOn(Dispatchers.IO)
        .catch { e -> e.printStackTrace() }

    override suspend fun getUser(): User? = loginLocalDS.getUser()

    override suspend fun deleteUser() = loginLocalDS.deleteUser()

}

interface LoginLocalDataSource {
    fun getUserToken(user: String): String?
    suspend fun setUser(userDto: AuthResponseDto): User?
    suspend fun getUser(): User?
    suspend fun deleteUser()
}

interface LoginRemoteDataSource {
    suspend fun userLogin(user: String, pass: String): ServiceResult<AuthResponseDto?>
}