package com.tharsis.deck_of_cards.utils.common

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class DataError<T>(val errorType: ErrorType, val exception: Throwable) : Resource<T>()
}

sealed class ErrorType(val message: String) {
    data object NetworkError : ErrorType(message = "Network connection error" )
    data class HttpError(val code: Int) : ErrorType(message = "HTTP error occurred. Code: $code")
    data object UnknownError : ErrorType(message = "An unknown error occurred")
}