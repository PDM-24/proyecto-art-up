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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.Exhibicion
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu

@ExperimentalMaterial3Api
@Composable
fun ExhibicionScreen(navController: NavController) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                navController = navController,
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen },
                username = "Username"
            )

            Exhibicion(
                navController = navController,
                onArtworkClick = { artworkId ->
                navController.navigate("artworkDetail/$artworkId")
            })
        }

        if (isSideMenuOpen) {
            SideMenu(
                isSideMenuOpen = isSideMenuOpen,
                navController = navController,
                onCloseSession = { /* Acción para cerrar sesión */ },
                onMenuClose = { isSideMenuOpen = false }
            )
        }

        BottomNavigation(
            onHomeClick = { navController.navigate("home") },
            onAddClick = { /* Lógica de navegación para agregar algo */ },
            onCameraClick = { /* Lógica de navegación para abrir la cámara */ }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ExhibicionScreenPreview() {
    ExhibicionScreen(navController = rememberNavController())
}
