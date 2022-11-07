package com.arthur.android_template.utils

import android.os.Build
import com.arthur.meal_db.utils.HttpError
import com.arthur.meal_db.utils.ServiceResult
import retrofit2.HttpException
import java.net.UnknownHostException
import java.time.temporal.UnsupportedTemporalTypeException

suspend fun <T> networkCall(
    call: suspend () -> T
): ServiceResult<T> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    try {
        ServiceResult.Success(dto = call())
    } catch (e: UnknownHostException) {
        ServiceResult.Error(message = "Revisa tu conexión a internet.")
    } catch (e: HttpException) {
        ServiceResult.Error(message = HttpError.fromCode(e.code()).errorMsg)
    } catch (e: UnsupportedTemporalTypeException) {
        ServiceResult.Error(message = "Campo de fecha inválido: " + e.message!!)
    } catch (e: java.lang.ClassCastException) {
        ServiceResult.Error(message = "Problemas al castear la respuesta: " + e.message!!)
    } catch (e: Exception) {
        e.printStackTrace()
        ServiceResult.Error(message = "Ocurrio un problema inesperado")
    }
} else {
    try {
        ServiceResult.Success(dto = call())
    } catch (e: UnknownHostException) {
        ServiceResult.Error(message = "Revisa tu conexión a internet.")
    } catch (e: HttpException) {
        ServiceResult.Error(message = HttpError.fromCode(e.code()).errorMsg)
    } catch (e: ClassCastException) {
        ServiceResult.Error(message = "Problemas al castear la respuesta: " + e.message!!)
    } catch (e: Exception) {
        e.printStackTrace()
        ServiceResult.Error(message = "Ocurrio un problema inesperado")
    }
}