package com.kguard.data.datasource

import java.io.IOException

sealed class NetworkException(message: String) : IOException(message) {
    class BadRequestError(message: String):NetworkException(message) //400
    class UnauthorizedError(message: String):NetworkException(message) //401
    class ForbiddenError(message: String):NetworkException(message) //403
    class NotFoundError(message: String): NetworkException(message) //404
    class NotImplementedError(message: String): NetworkException(message) // 501
    class BadGatewayError(message: String): NetworkException(message) //502
    class GatewayTimeoutError(message: String): NetworkException(message) //504
}