package com.example.campfinalproject.pages.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.campfinalproject.core.approuts.Router
import kotlinx.coroutines.delay

@Composable
fun LandingPage(navigationController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    
    ) {
        CircularProgressIndicator()
        Text(text = "Loadnig .... ")

    }
    LaunchedEffect(Unit){
        delay(1000)
        navigationController.navigate(Router.LoginPage.route)
    }
}