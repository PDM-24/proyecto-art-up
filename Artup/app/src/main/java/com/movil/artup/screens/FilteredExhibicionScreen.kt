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
import com.movil.artup.components.FilteredExhibicion
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu

@ExperimentalMaterial3Api
@Composable
fun FilteredExhibicionScreen(navController: NavController, filterType: String) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen }, // Cambia el estado del SideMenu
                onSearchClick = { /* Lógica para abrir el Search*/ },
                username = "Username",
                isVerified = true
            )

            FilteredExhibicion(navController = navController, filterType = filterType, onArtworkClick = { artworkId ->
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
            onHomeClick = { navController.navigate("perfil") },
            onAddClick = { navController.navigate("add") }, // Suponiendo que tienes una ruta "add"
            onMarketClick = { navController.navigate("market") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FilteredExhibicionScreenPreview() {
    FilteredExhibicionScreen(navController = rememberNavController(), filterType = "human")
}
