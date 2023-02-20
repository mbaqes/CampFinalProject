package com.example.campfinalproject.pages.loginpage

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.campfinalproject.core.approuts.Router
import com.example.campfinalproject.pages.loginpage.composible.LoginForm
import kotlinx.coroutines.flow.collectLatest


@Composable
fun LoginPage(navHostController: NavController,vmLogin:LoginViewModel= hiltViewModel()) {
    var txtUserName by remember {
        mutableStateOf("")
    }
    var txtPassowrd by remember {
        mutableStateOf("")
    }
    var showError by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit ){
         vmLogin.status.collectLatest {
            if(it.status == Status.success){
                 navHostController.navigate(Router.HomePage.route){
                    popUpTo(Router.LandingPage.route){
                        inclusive=true
                    }
                }
            }else if(it.status == Status.error){

            }
        }

    }
    Scaffold(modifier = Modifier.fillMaxSize()) {
        it.calculateTopPadding()
       Column(modifier = Modifier.fillMaxSize()) {
           TextField(value = txtUserName, onValueChange ={
               txtUserName=it
           })
           TextField(value = txtPassowrd, onValueChange = {
               txtPassowrd=it
           })
           Button(onClick = {
               vmLogin.login(txtUserName,txtPassowrd)
           }) {

           }
       }
    }
}