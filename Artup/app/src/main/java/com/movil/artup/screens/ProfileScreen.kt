// src/main/kotlin/com/movil/artup/screens/ProfileScreen.kt
package com.movil.artup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu
import com.movil.artup.components.UserProfileScreen

@Composable
fun ProfileScreen(navController: NavController) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                navController = navController,
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen },
                username = "Username"
            )

            UserProfileScreen(
                navController = navController,
                onSearchClick = { /* Lógica de búsqueda */ },
                onFilterClick = { /* Lógica de filtro */ },
                onArtworkClick = { artworkId ->
                    navController.navigate("artworkDetail/$artworkId")
                }
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
}

@Preview(showBackground = true)
@Composable
fun VistaProfile() {
    ProfileScreen(navController = rememberNavController())
}
