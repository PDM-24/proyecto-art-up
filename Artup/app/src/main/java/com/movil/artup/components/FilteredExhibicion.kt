package com.movil.artup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movil.artup.R

@Composable
fun FilteredExhibicion(navController: NavController, filterType: String) {
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

                val title = when (filterType) {
                    "human" -> "Human"
                    "car" -> "Carros"
                    else -> "Exhibición"
                }

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )

                val filteredArtworks = when (filterType) {
                    "human" -> artworks.filter { it.imageResId == R.drawable.artwork1 || it.imageResId == R.drawable.artwork2 }
                    "car" -> artworks.filter { it.imageResId == R.drawable.artwork3 || it.imageResId == R.drawable.artwork4 }
                    else -> artworks
                }

                LazyColumn {
                    items(filteredArtworks) { artwork ->
                        Image(
                            painter = painterResource(id = artwork.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

data class Artworkk(val imageResId: Int)

val artwork = listOf(
    Artwork(R.drawable.artwork1),
    Artwork(R.drawable.artwork2),
    Artwork(R.drawable.artwork3),
    Artwork(R.drawable.artwork4)
)
