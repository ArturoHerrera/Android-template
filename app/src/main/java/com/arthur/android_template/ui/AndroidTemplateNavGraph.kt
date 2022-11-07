package com.arthur.android_template.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arthur.android_template.ui.screens.login.LoginScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

object Destinations {
    const val LOGIN_SCREEN = "login"
    const val SPLASH_SCREEN = "splash"
    const val HOME_SCREEN = "home"
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun AndroidTemplateNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.SPLASH_SCREEN
) {
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.SPLASH_SCREEN) {
            LoginScreen(
                navigateToView = actions.navigateToHome,
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(Destinations.HOME_SCREEN)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}