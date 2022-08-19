package com.arthur.android_template.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arthur.android_template.ui.theme.TotalPlaytestTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun AndroidTemplateApp() {
    TotalPlaytestTheme {
        val navController = rememberNavController()

        Scaffold {
            TMDBNavGraph(
                navController = navController
            )
        }

    }
}