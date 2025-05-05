package com.example.listing

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class AsyncState<out T> {
    data object Loading : AsyncState<Nothing>()
    data class Success<out T>(val data: T) : AsyncState<T>()
    data class Error(val errorMessage: String) : AsyncState<Nothing>()
} 