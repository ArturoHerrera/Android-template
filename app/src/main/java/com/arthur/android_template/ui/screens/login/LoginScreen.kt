package com.arthur.android_template.ui.screens.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun LoginScreen(
    navigateToView: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface() {
                if (uiState.loading) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp),
                        color = MaterialTheme.colors.secondary
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(text = "Hola Android!!")

                }
            }

        }
    }
}