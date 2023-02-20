package com.example.campfinalproject.pages.homepage.data.repository

import com.example.campfinalproject.pages.homepage.data.model.Store
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts():Flow<Store>
}