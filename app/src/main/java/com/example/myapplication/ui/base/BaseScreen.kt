package com.example.myapplication.ui.base

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.HomeScreen

@Composable
fun BaseScreen(startDestination:String) {
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = startDestination) {
            composable(NavScreen.Home.route){
                HomeScreen(navController)
            }
        }

}

sealed class NavScreen(val route: String, @StringRes val resourceId: Int? = null, val icon: ImageVector? = null) {

    object Splash : NavScreen("Splash")

    object Home : NavScreen("Home")
    object Test1 : NavScreen("Test1")
    object Test2 : NavScreen("Test2")

}