package com.movil.artup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.movil.artup.R


@Composable
fun UserProfileScreen(
    navController: NavController,
    onSearchClick: () -> Unit = {},
    onFilterClick: () -> Unit = {},
    onArtworkClick: () -> Unit = {}
) {
    Scaffold(
        // Eliminamos el parámetro topBar
    ) { innerPadding ->
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
                        onClick = { /* Acción para Todo */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Todo")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = { /* Acción para Exhibición */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(text = "Exhibición")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalStaggeredGrid(
                    StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    content = {
                        items(artworks) { artwork ->
                            Image(
                                painter = painterResource(id = artwork.imageResId),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(2.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                )
            }
        }
    }
}



// Datos de muestra para las obras de arte
data class Artwork(val imageResId: Int)

val artworks = listOf(
    Artwork(R.drawable.artwork1), // Ajusta la relación de aspecto según sea necesario
    Artwork(R.drawable.artwork2),
    Artwork(R.drawable.artwork3),
    Artwork(R.drawable.artwork4)
)




