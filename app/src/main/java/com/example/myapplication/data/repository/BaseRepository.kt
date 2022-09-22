package com.example.myapplication.data.repository

import com.example.myapplication.data.network.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resources<T> {
        return  withContext(Dispatchers.IO){
            try{
                Resources.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        Resources.Failure(true, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resources.Failure(true, null, null)
                    }
                }
            }
        }
    }
}