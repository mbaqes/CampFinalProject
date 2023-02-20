package com.example.campfinalproject.core.approuts

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController

sealed class Router(val title:String,val route:String,icon:ImageVector){
companion object{
     @SuppressLint("StaticFieldLeak")
     @Volatile
    var navigator : NavController? =null
    fun navigatorInit(nav:NavHostController){
           navigator=nav
    }
}
    object LandingPage:Router(title = "LandingPage","LandingPage",Icons.Rounded.Person) // Show Somthing For User
    object LoginPage:Router(title = "LoginPage","LoginPage",Icons.Rounded.Lock) // SecondPage If we get Unauthenticated User
    object HomePage:Router(title = "HomePage","HomePage",Icons.Rounded.Home) // HOME PAGE WITH Bottom navigation bar
}
