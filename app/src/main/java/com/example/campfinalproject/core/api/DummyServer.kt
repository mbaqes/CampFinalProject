package com.example.campfinalproject.core.api

import com.example.campfinalproject.core.authintactionstor.model.User
import com.example.campfinalproject.core.constins.Constins
import com.example.campfinalproject.pages.homepage.data.model.Store
import com.example.campfinalproject.pages.loginpage.requstdto.LoginRequstDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DummyServer {
    @GET(Constins.ENDPOINT)
    suspend fun getProducts(@Header("Authorization") token:String):Response<Store>
    @POST(Constins.ENDPOINTLOGIN)
    suspend fun login(@Body requset:LoginRequstDto):Response<User>
}
