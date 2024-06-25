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
import com.movil.artup.Publication
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.Exhibicion
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu

@ExperimentalMaterial3Api
@Composable
fun ExhibicionScreen(navController: NavController/*, publications: List<Publication>*/) {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = {
                    isSideMenuOpen = !isSideMenuOpen
                }, // Cambia el estado del SideMenu
                onSearchClick = { /* Lógica para abrir el Market */ },
                username = "Username",
                isVerified = true
            )

            Exhibicion(navController = navController/*, publications = publications*/)
        }
        BottomNavigation(
            onHomeClick = { navController.navigate("perfil") },
            onAddClick = { navController.navigate("sell") },
            onMarketClick = { navController.navigate("market") }
        )
    }

        // SideMenu

    if (isSideMenuOpen) {
        SideMenu(
            isSideMenuOpen = isSideMenuOpen,
            navController = navController,
            onCloseSession = { /* Lógica para cerrar sesión */ },
            onMenuClose = { isSideMenuOpen = false }
        )
    }
}




