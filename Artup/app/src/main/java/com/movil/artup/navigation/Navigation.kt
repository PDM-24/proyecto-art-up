package com.movil.artup.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.FirebaseUser
import com.movil.artup.Login.LoginViewModel
import com.movil.artup.components.LoginScreen
import com.movil.artup.components.SignUpInstScreen
import com.movil.artup.components.SignUpScreen
import com.movil.artup.components.WelcomeScreen
import com.movil.artup.screens.EditProfileScreen
import com.movil.artup.screens.ExhibicionScreen
import com.movil.artup.screens.ProfileScreen


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    val authManager = LoginViewModel()
    val user:FirebaseUser? = authManager.getCurrentUser()
    NavHost(
        navController = navController,
        startDestination = if(user==null) ScreenRoute.WelcomeScreen.route else ScreenRoute.ExhibicionScreen.route
        /*ScreenRoute.WelcomeScreen.route*/

    ) {


            composable(ScreenRoute.ProfileScreen.route) {
                ProfileScreen(navController)
            }
            composable(ScreenRoute.ExhibicionScreen.route) {
                ExhibicionScreen(navController)
            }
            composable(ScreenRoute.EditProfileScreen.route) {
                EditProfileScreen(navController)
            }
            composable(ScreenRoute.WelcomeScreen.route) {
                WelcomeScreen(navController)
            }
            composable(ScreenRoute.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(ScreenRoute.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(ScreenRoute.SignUpInstScreen.route) {
                SignUpInstScreen(navController)

        }
    }
}