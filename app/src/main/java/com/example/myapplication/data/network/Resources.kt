package com.example.myapplication.data.network

import okhttp3.ResponseBody
import okhttp3.internal.http2.ErrorCode

//class to wrap the API response
sealed class Resources<out T> {
    data class Success<out T>(val value: T) : Resources<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resources<Nothing>()
}