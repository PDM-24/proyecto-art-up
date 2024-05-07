package com.movil.artup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.SideMenu
import com.movil.artup.components.UserProfileScreen
import androidx.compose.runtime.*
import com.movil.artup.components.HeaderProfile

@Composable
fun ProfileScreen() {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen }, // Cambia el estado del SideMenu
                onMarketClick = { /* Lógica para abrir el Market */ },
                username = "Username"
            )

            UserProfileScreen(
                navController = rememberNavController(),
                onSearchClick = { /* Lógica de búsqueda */ },
                onFilterClick = { /* Lógica de filtro */ },
                onArtworkClick = { /* Lógica de la obra de arte */ }
            )
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


@Preview(showBackground = true)
@Composable
fun VistaProfile() {
    ProfileScreen()
}
