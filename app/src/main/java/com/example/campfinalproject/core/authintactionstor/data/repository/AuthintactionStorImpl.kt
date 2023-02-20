package com.example.campfinalproject.core.authintactionstor.data.repository

import android.content.SharedPreferences
import com.example.campfinalproject.core.authintactionstor.data.model.User
import com.example.campfinalproject.core.extinion.fromJson
import com.example.campfinalproject.core.extinion.toJson
import javax.inject.Inject

class AuthintactionStorImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AuthintactionStor {
    private val keyUser = "authuser"
    private val keyToken = "authToken"


    override fun storeAuthUser(user: User) {
        val sp = sharedPreferences.edit()
        sp.putString(keyUser, user.toJson())
        sp.apply()
    }

    override fun retreveAuthUser(): User {
        val user = sharedPreferences.getString(keyUser, null)!!
            .fromJson(User::class.java)
        return user
    }

    override fun storeToken(token: String) {
        val sp = sharedPreferences.edit()
        sp.putString(keyToken, token)
        sp.apply()
    }

    override fun retrveToken(): String {
        return sharedPreferences.getString(keyToken, null) ?: return ""

    }

    override fun storeFirstLanch(isfirst: Boolean) {
        TODO("Not yet implemented")
    }

    override fun retrveFirstLanch(): Boolean {
        TODO("Not yet implemented")
    }
}