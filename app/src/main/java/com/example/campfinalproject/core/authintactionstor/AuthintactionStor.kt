package com.example.campfinalproject.core.authintactionstor

import com.example.campfinalproject.core.authintactionstor.model.User

interface AuthintactionStor {
    fun storeAuthUser(user: User)
    fun retreveAuthUser(): User
    fun storeToken(token:String)
    fun retrveToken():String
    fun storeFirstLanch(isfirst:Boolean)
    fun retrveFirstLanch():Boolean

}