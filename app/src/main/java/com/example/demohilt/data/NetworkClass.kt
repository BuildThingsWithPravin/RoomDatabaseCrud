package com.example.demohilt.data

sealed class NetworkClass<T>(val data: T?, val message: String) {

    class Success<T>(data: T, message: String) : NetworkClass<T>(data, message)
    class Error<T>(message: String) : NetworkClass<T>(null, message)
    class Loading<T> : NetworkClass<T>(null, "Loading")

}
