package com.arthur.android_template.ui.screens.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

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
    ) { mPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(mPaddingValues)
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

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { viewModel.login("superman@gmail.com", "123456") }
                        ) {
                            Text(text = "Fake success login")
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(
                            onClick = { viewModel.login("fakeemail@gmail.com", "123456fakepass") }
                        ) {
                            Text(text = "Fake failed login")
                        }
                    }

                    uiState.loginSuccess?.let {
                        if (it) {
                            Text(text = "Login Success!! :D")

                            uiState.user?.let { safeUser ->
                                Text(text = "email: ${safeUser.userEmail}")
                                Text(text = "name: ${safeUser.userName}")
                            }
                        } else {
                            Text(text = "Ohh nooo!! D:")
                        }
                    }
                }
            }
        }
    }
}