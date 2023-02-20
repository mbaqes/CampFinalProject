package com.example.campfinalproject.pages.loginpage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campfinalproject.core.authintactionstor.AuthintactionStor
import com.example.campfinalproject.pages.loginpage.data.repository.LoginRepository
import com.example.campfinalproject.pages.loginpage.requstdto.LoginRequstDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class State(var status: Status = Status.initstatus)
enum class Status {
    initstatus, error, success;
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    var status = MutableStateFlow(State())
    fun login(username:String,passowrd:String) {
        viewModelScope.launch {
            loginRepository.login(LoginRequstDto(username,passowrd)).onEach {
                if(it!=null){
                    status.value =status.value.copy(Status.success)
                }
            }.launchIn(this)
        }


    }
}