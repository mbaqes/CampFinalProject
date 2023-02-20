package com.example.campfinalproject.pages.loginpage

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.campfinalproject.core.authintactionstor.data.repository.AuthintactionStor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

data class State(var status: Status = Status.initstatus)
enum class Status {
    initstatus, error, success;
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authintactionStore: AuthintactionStor
) : ViewModel() {
    var status = MutableStateFlow(State())
    init {
        val token = authintactionStore.retrveToken()
        if (token.isEmpty()) {
            status.value = status.value.copy(Status.error)
        } else {
            Log.d("sss", token)
            status.value = status.value.copy(Status.success)
        }
    }
    fun login() {
        authintactionStore.storeToken("------>>>aIKAKmsakskokasfaks12k12kka<<<<")
        status.value = status.value.copy(Status.error)
    }
}