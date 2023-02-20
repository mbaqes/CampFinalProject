package com.example.campfinalproject.core.approuts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.campfinalproject.pages.homepage.HomePage
import com.example.campfinalproject.pages.homepage.LandingPage
import com.example.campfinalproject.pages.loginpage.LoginPage
@Composable
fun AppNavigationHost(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = Router.LandingPage.route) {
        composable(Router.LandingPage.route) {
            LandingPage(navigationController)
        }
        composable(Router.LoginPage.route) {
            LoginPage(navigationController)
        }
        composable(Router.HomePage.route) {
            HomePage()
        }
    }
}