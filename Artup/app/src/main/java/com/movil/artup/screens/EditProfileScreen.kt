package com.movil.artup.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.EditProfile
import com.movil.artup.components.HeaderProfile

@ExperimentalMaterial3Api
@Composable
fun EditProfileScreen(navController: NavController
) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                navController = navController,
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen },
                username = "Username"
            )

            EditProfile(navController)
        }

        // SideMenu





        // BottomNavigation
        BottomNavigation(
            onHomeClick = { /* Lógica de navegación para ir a la pantalla de inicio */ },
            onAddClick = { /* Lógica de navegación para agregar algo */ },
            onCameraClick = { /* Lógica de navegación para abrir la cámara */ }
        )
    }
}



