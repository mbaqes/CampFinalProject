package com.example.campfinalproject.pages.homepage

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campfinalproject.core.authintactionstor.data.repository.AuthintactionStorImpl
import com.example.campfinalproject.pages.homepage.data.model.Store
import com.example.campfinalproject.pages.homepage.data.repository.ProductRepository
import com.example.campfinalproject.pages.homepage.data.repository.ProductRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repo: ProductRepository,
    private val authintactionStorImpl: AuthintactionStorImpl
 ) : ViewModel() {
    init {
        getListStore()
    }
    var state = MutableStateFlow<Store>(Store(limit = 0, products = listOf(), skip = 0, total = 0))
    fun getListStore() {
        viewModelScope.launch {
            repo.getProducts().onEach { store ->
                state.value = store
            }.launchIn(this)

        }
    }
}