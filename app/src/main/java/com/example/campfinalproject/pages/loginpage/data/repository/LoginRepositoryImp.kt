package com.example.campfinalproject.pages.loginpage.data.repository

import com.example.campfinalproject.core.api.DummyServer
import com.example.campfinalproject.core.authintactionstor.model.User
import com.example.campfinalproject.core.authintactionstor.AuthintactionStor
import com.example.campfinalproject.pages.loginpage.requstdto.LoginRequstDto
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
  private  val authintactionStor: AuthintactionStor,
  private val dummyServer: DummyServer,
) :LoginRepository {
    override fun login(rqustDto:LoginRequstDto)= flow<User?> {
      val respose=  dummyServer.login(rqustDto)
        if (respose.isSuccessful){
            val user = respose.body()
            authintactionStor.storeAuthUser(user!!)
            authintactionStor.storeToken(user!!.token)
            emit(user)
        }
    }
}