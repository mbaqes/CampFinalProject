package com.example.campfinalproject.pages.homepage.data.repository

import android.content.SharedPreferences
import com.example.campfinalproject.core.api.DummyServer
import com.example.campfinalproject.core.authintactionstor.data.repository.AuthintactionStorImpl
import com.example.campfinalproject.pages.homepage.data.model.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(
    private val dummyServer: DummyServer,

) : ProductRepository {
    override suspend fun getProducts(): Flow<Store> {
        return flow {
            val response = dummyServer.getProducts()
            if (response.isSuccessful) {
                emit(response.body()!!)
            }
        }
    }
}