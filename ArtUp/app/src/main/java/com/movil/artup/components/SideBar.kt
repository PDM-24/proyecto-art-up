package com.movil.artup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun SideMenu(
    isSideMenuOpen: Boolean,
    navController: NavController,
    onCloseSession: () -> Unit = {},
    onMenuClose: () -> Unit = {} // Callback para cerrar el menú
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.8f))
            .clickable { onMenuClose() } // Cierra el menú al hacer clic fuera del mismo
    ) {
        if (isSideMenuOpen) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterStart)
                    .background(Color.White)
                    .clickable(enabled = false) {} // Evita que el clic en el menú cierre el menú
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MenuItem(text = "Home", navController = navController, route = "home")
                    MenuItem(text = "Profile", navController = navController, route = "perfil")
                    MenuItem(text = "Artists", navController = navController, route = "artists")
                    MenuItem(text = "Market", navController = navController, route = "market")
                    MenuItem(text = "Events", navController = navController, route = "events")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onCloseSession,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Cerrar sesión", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
private fun MenuItem(text: String, navController: NavController, route: String) {
    Button(
        onClick = {
            navController.navigate(route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            color = Color.Black // Cambiado a negro para mejor visibilidad en fondo blanco
        )
    }
}



