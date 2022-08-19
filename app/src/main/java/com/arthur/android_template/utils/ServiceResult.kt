package com.arthur.android_template.utils

sealed class ServiceResult<out R> {
    data class Success<out T>(val dto: T?, val responseCode: Int): ServiceResult<T>()
    data class Error(val message: String, val errorCode: Int): ServiceResult<Nothing>()
}

val ServiceResult<*>.succeeded
    get() = this is ServiceResult.Success && dto != null

fun <T> ServiceResult<T>.getDto(): T {
    return (this as ServiceResult.Success<T>).dto!!
}

fun ServiceResult<*>.getResponseCode(): Int {
    return (this as ServiceResult.Success).responseCode
}

fun ServiceResult<*>.getMessage(): String {
    return (this as ServiceResult.Error).message
}

fun ServiceResult<*>.getErrorCode(): Int {
    return (this as ServiceResult.Error).errorCode
}

//TODO Add errorMsg to resources
enum class HttpError(val code: Int, val errorMsg: String) {
    Success(200, "Todo OK."),
    BadRequest(400, "El servidor no pudo interpretar la solicitud."),
    Unauthorized(401, "Es necesario autenticar para obtener la respuesta solicitada."),
    Forbidden(403, "El cliente no posee los permisos necesarios para cierto contenido, por lo que el servidor está rechazando otorgar una respuesta apropiada."),
    NotFound(404, "El servidor no pudo encontrar el contenido solicitado."),
    MethodNotAllowed(405, "El método solicitado es conocido por el servidor pero ha sido deshabilitado y no puede ser utilizado."),
    NotAcceptable(406, "No se encontró el contenido."),
    RequestTimeout(408, "El servidor agotó el tiempo de espera de la solicitud."),
    Conflict(409, "El recurso solicitado ya no está disponible y no volverá a estar disponible"),
    InternalServerError(500, "Error interno del servidor."),
    NotImplemented(501, "El método solicitado no está soportado por el servidor y no puede ser manejado."),
    BadGateway(502, "El servidor estaba actuando como puerta de enlace o proxy y recibió una respuesta no válida del servidor ascendente."),
    ServiceUnavailable(503, "El servidor no está listo para manejar la petición."),
    GatewayTimeout(504, "El servidor está actuando como una puerta de enlace y no puede obtener una respuesta a tiempo."),
    Unknown(-1, "Error inesperado. Intentelo de nuevo. Si el error persiste contacte con soporte.");

    companion object {
        private val map = values().associateBy(HttpError::code)
        fun fromCode(errorCode: Int) = map[errorCode] ?: Unknown
    }
}