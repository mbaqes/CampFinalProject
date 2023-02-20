package com.example.campfinalproject.core.extinion

import com.google.gson.Gson

fun <T> T.toJson(): String {
    return Gson().toJson(this)
}

fun <T> String.fromJson(clss: Class<T>): T {
    return Gson().fromJson(this, clss)
}