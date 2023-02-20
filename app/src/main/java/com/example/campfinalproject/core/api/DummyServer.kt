package com.example.campfinalproject.core.api

import com.example.campfinalproject.core.constins.Constins
import com.example.campfinalproject.pages.homepage.data.model.Store
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface DummyServer {
    @GET(Constins.ENDPOINT)
    suspend fun getProducts():Response<Store>
    suspend fun login(@Body() UserRequstDto)
}
val token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTY3Njg5NTQ3NSwiZXhwIjoxNjc2ODk5MDc1fQ.WiRxAmv2HrNSoIZvYHJNYwl0KIhkHOAxsLnwjjT9zm8"