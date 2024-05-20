package com.movil.artup


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movil.artup.screens.EditProfileScreen
import com.movil.artup.screens.ExhibicionScreen
import com.movil.artup.screens.ProfileScreen

@ExperimentalMaterial3Api
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MyApp() {
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "perfil"
    ) {
        composable("perfil") {
            ProfileScreen(navController)
        }
        composable("exhibicion") {
            ExhibicionScreen(navController)
        }
        composable("editarperfil"){
            EditProfileScreen(navController)
        }
    }
}



@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Appp() {
    MyApp()
}
