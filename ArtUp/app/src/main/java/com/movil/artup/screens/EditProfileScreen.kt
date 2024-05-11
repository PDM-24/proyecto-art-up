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
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.EditProfile
import com.movil.artup.components.Exhibicion
import com.movil.artup.components.HeaderProfile

@ExperimentalMaterial3Api
@Composable
fun EditProfileScreen() {
    var isSideMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen }, // Cambia el estado del SideMenu
                onSearchClick = { /* Lógica para abrir el Search*/ },
                username = "Username"
            )

            EditProfile()
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



@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun VistaEditProfile() {
    EditProfileScreen()
}