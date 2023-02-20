package com.example.campfinalproject.core.authintactionstor.data.repository

import com.example.campfinalproject.core.authintactionstor.data.model.User

interface AuthintactionStor {
    fun storeAuthUser(user: User)
    fun retreveAuthUser():User
    fun storeToken(token:String)
    fun retrveToken():String
    fun storeFirstLanch(isfirst:Boolean)
    fun retrveFirstLanch():Boolean

}