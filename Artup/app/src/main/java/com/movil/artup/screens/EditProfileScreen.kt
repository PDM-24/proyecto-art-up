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
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen }, // Cambia el estado del SideMenu
                onSearchClick = { /* Lógica para abrir el Search*/ },
                username = "Username",
                isVerified = true
            )

            EditProfile(navController)
        }

        // SideMenu





        // BottomNavigation
        BottomNavigation(
            onHomeClick = { /* Lógica de navegación para ir a la pantalla de inicio */ },
            onAddClick = { /* Lógica de navegación para agregar algo */ },
            onMarketClick = { /* Lógica de navegación para abrir la cámara */ }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun PreviewEditProfile (){
    val navController = rememberNavController()
    EditProfileScreen(navController)
}



