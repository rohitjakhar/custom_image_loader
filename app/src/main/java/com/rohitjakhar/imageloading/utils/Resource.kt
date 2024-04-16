package com.rohitjakhar.imageloading.utils

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val errorMessage: String) : Resource<Nothing>()
    data class Empty(val empty: Unit) : Resource<Nothing>()
}