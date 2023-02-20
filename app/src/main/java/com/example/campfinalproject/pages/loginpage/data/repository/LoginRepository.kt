package com.example.campfinalproject.pages.loginpage.data.repository

import com.example.campfinalproject.core.authintactionstor.data.model.User

interface LoginRepository {
    fun login(user:User)
}