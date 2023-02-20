package com.example.campfinalproject.pages.homepage.data.repository

import com.example.campfinalproject.core.api.DummyServer
import com.example.campfinalproject.core.authintactionstor.AuthintactionStor
import com.example.campfinalproject.pages.homepage.data.model.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(
    private val dummyServer: DummyServer,
private val authintactionStor: AuthintactionStor,
) : ProductRepository {
    override suspend fun getProducts(): Flow<Store> {

        return flow {
          val token=  authintactionStor.retrveToken()
            val response = dummyServer.getProducts(token)
            if (response.isSuccessful) {
                emit(response.body()!!)
            }
        }
    }
}