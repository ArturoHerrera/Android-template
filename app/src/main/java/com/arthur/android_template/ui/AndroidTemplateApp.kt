package com.arthur.android_template.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arthur.android_template.ui.theme.AndroidTemplateTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun AndroidTemplateApp() {
    AndroidTemplateTheme {
        val navController = rememberNavController()

        Scaffold {
            AndroidTemplateNavGraph(
                navController = navController
            )
        }

    }
}