package com.movil.artup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.R
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.HeaderProfile
import com.movil.artup.components.SideMenu
import com.movil.artup.components.artworks

@ExperimentalMaterial3Api
@Composable
fun ArtworkDetailScreen(navController: NavController, artworkId: Int) {
    var isSideMenuOpen by remember { mutableStateOf(false) }
    val artwork = artworks.firstOrNull { it.imageResId == artworkId }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderProfile(
                onBurgerClick = { isSideMenuOpen = !isSideMenuOpen }, // Cambia el estado del SideMenu
                onSearchClick = { /* Lógica para abrir el Search*/ },
                username = "Username",
                isVerified = true
            )

            if (artwork != null) {
                Image(
                    painter = painterResource(id = artwork.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                ){}
                Row {
                    Text(
                        text = "4 de marzo de 2024",
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Icon",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(30.dp))
                }

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            } else {
                Text(text = "Artwork not found", modifier = Modifier.padding(16.dp))
            }
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
fun ArtworkDetailScreenPreview() {
    ArtworkDetailScreen(navController = rememberNavController(), artworkId = R.drawable.artwork1)
}
