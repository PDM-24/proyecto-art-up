package com.movil.artup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.movil.artup.R

@Composable
fun ArtworkDetailed(artworkId: Int) {
    val artwork = artworks.firstOrNull { it.imageResId == artworkId }

    Column(modifier = Modifier.fillMaxSize()) {
        if (artwork != null) {
            Image(
                painter = painterResource(id = artwork.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                text = "4 de marzo de 2024",
                modifier = Modifier.padding(16.dp)
            )
        }
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        } else {
            Text(text = "Artwork not found", modifier = Modifier.padding(16.dp))
        }
    }
}