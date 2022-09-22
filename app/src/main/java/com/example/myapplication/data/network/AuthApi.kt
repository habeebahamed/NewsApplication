package com.example.myapplication.data.network

import com.example.myapplication.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//inerface to define the network call
interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) : LoginResponse
}