package com.movil.artup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movil.artup.R

@Composable
fun Exhibicion(
    navController: NavController,
    onArtworkClick: (Int) -> Unit // Añadido aquí
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.starry_night),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .clickable { navController.navigate("editarperfil") }
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = "Email: username@gmail.com")
                        Text(text = "Ig: usernamelig")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Button(
                        onClick = { navController.navigate("perfil") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(text = "Todo")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = { /* Acción para Exhibición */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Exhibición")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Human",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController.navigate("filteredExhibicion/human") }
                )

                Row {
                    for (artwork in artworks) {
                        Image(
                            painter = painterResource(id = artwork.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clickable { onArtworkClick(artwork.imageResId) } // Añadido aquí
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Carros",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController.navigate("filteredExhibicion/car") }
                )

                Row {
                    for (artwork in artworks) {
                        Image(
                            painter = painterResource(id = artwork.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clickable { onArtworkClick(artwork.imageResId) } // Añadido aquí
                        )
                    }
                }
            }
        }
    }
}

data class Artwork(val imageResId: Int)

val artworks = listOf(
    Artwork(R.drawable.artwork1),
    Artwork(R.drawable.artwork2),
    Artwork(R.drawable.artwork3),
    Artwork(R.drawable.artwork4)
)
