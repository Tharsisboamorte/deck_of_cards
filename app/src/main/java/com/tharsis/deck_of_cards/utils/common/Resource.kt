package com.tharsis.deck_of_cards.utils.common

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class DataError<T>(val errorType: ErrorType, val exception: Throwable) : Resource<T>()
}

sealed class ErrorType {
    data object NetworkError : ErrorType()
    data class HttpError(val code: Int) : ErrorType()
    data object UnknownError : ErrorType()
}