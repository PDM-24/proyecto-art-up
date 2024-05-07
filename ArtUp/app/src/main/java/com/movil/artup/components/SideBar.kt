package com.movil.artup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movil.artup.R
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha


@Composable
fun SideMenu(
    isSideMenuOpen: Boolean,
    onCloseSession: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.8f))
    ) {
        if (isSideMenuOpen) {
            Column(
                modifier = Modifier
                    .fillMaxHeight() // Hace que el Column ocupe toda la altura
                    .width(200.dp) // Establece un ancho fijo para el menú
                    .padding(vertical = 16.dp) // Ajusta el padding vertical para que abarque la mitad de la pantalla en vertical
                    .align(Alignment.CenterStart) // Alinea el menú a la izquierda
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MenuItem(text = "Home")
                    MenuItem(text = "Profile")
                    MenuItem(text = "Artists")
                    MenuItem(text = "Market")
                    MenuItem(text = "Events")
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
private fun MenuItem(text: String) {
    Button(
        onClick = { /* Lógica de navegación */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Añade relleno vertical entre botones
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(0.dp) // Elimina el relleno interno del botón
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}


