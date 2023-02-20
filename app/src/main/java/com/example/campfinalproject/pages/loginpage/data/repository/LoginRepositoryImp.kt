package com.example.campfinalproject.pages.loginpage.data.repository

import com.example.campfinalproject.core.api.DummyServer
import com.example.campfinalproject.core.authintactionstor.data.model.User
import com.example.campfinalproject.core.authintactionstor.data.repository.AuthintactionStor
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    authintactionStor: AuthintactionStor,
    dummyServer: DummyServer,
) :LoginRepository {
    override fun login(user: User) {

    }
}