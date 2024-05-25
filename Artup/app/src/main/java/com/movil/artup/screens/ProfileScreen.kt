package com.movil.artup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu
import com.movil.artup.components.UserProfileScreen

@Composable
fun ProfileScreen(navController: NavController) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen },
                onSearchClick = { /* Lógica para abrir el Market */ },
                username = "Username",
                isVerified = true
            )

            UserProfileScreen(
                navController = navController,
                onSearchClick = { /* Lógica de búsqueda */ },
                onFilterClick = { /* Lógica de filtro */ },
                onArtworkClick = { /* Lógica de la obra de arte */ }
            )
        }

            BottomNavigation(
                onHomeClick = { /* Lógica de navegación para ir a la pantalla de inicio */ },
                onAddClick = { /* Lógica de navegación para agregar algo */ },
                onCameraClick = { /* Lógica de navegación para abrir la cámara */ }
            )
        }

        if (isSideMenuOpen) {
            SideMenu(
                isSideMenuOpen = isSideMenuOpen,
                navController = navController,
                onCloseSession = { /* Lógica para cerrar sesión */ },
                onMenuClose = { isSideMenuOpen = false }
            )


        }

    }



@Preview(showBackground = true)
@Composable
fun VistaProfile() {

}