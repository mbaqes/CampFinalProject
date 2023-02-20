package com.example.campfinalproject.pages.loginpage.composible

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.campfinalproject.core.approuts.Router
import com.example.campfinalproject.pages.loginpage.LoginViewModel

@Composable
fun LoginForm(
    onusernamechang: (String) -> Unit,
    onPassowrdchang: (String) -> Unit,
    txtUserName: String,
    txtPassowrd: String,
    vmLogin: LoginViewModel
) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = Router.LoginPage.title)
        TextField(value = txtUserName, onValueChange =onusernamechang)
        TextField(value = txtPassowrd, onValueChange = onPassowrdchang)


    }
}