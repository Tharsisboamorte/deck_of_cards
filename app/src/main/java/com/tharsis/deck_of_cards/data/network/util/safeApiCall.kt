package com.tharsis.deck_of_cards.data.network.util

import com.tharsis.deck_of_cards.domain.common.ErrorType
import com.tharsis.deck_of_cards.domain.common.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend inline fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    crossinline apiCall: suspend () -> T
): Resource<T> {
    return withContext(dispatcher) {
        try {
            val result = apiCall()
            Resource.Success(result)
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Resource.DataError(ErrorType.NetworkError, throwable)
                is HttpException -> {
                    val code = throwable.code()
                    Resource.DataError(ErrorType.HttpError(code), throwable)
                }
                else -> Resource.DataError(ErrorType.UnknownError, throwable)
            }
        }
    }
}