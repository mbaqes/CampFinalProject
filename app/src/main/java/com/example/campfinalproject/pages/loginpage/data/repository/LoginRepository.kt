package com.example.campfinalproject.pages.loginpage.data.repository

import com.example.campfinalproject.core.authintactionstor.model.User
import com.example.campfinalproject.pages.loginpage.requstdto.LoginRequstDto
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(user: LoginRequstDto): Flow<User?>
}