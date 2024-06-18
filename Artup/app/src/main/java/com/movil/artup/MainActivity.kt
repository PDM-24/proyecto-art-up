package com.movil.artup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movil.artup.components.LoginScreen
import com.movil.artup.components.SignUpInstScreen
import com.movil.artup.components.SignUpScreen
import com.movil.artup.components.WelcomeScreen
import com.movil.artup.navigation.Navigation
import com.movil.artup.screens.EditProfileScreen
import com.movil.artup.screens.ExhibicionScreen
import com.movil.artup.screens.ProfileScreen

@ExperimentalMaterial3Api
class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}





@SuppressLint("NewApi")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Appp() {
    Navigation()
}
