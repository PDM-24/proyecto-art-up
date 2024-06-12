package com.movil.artup.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movil.artup.R

@Composable
fun BottomNavigation(
    onHomeClick: () -> Unit = {},
    onAddClick: () -> Unit = {},
    onMarketClick: () -> Unit = {}
) {
    BottomAppBar(
        containerColor = Color.Black.copy(alpha = 0.8f),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onHomeClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.house_solid),
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = onAddClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_plus_solid),
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = onMarketClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.store_solid),
                        contentDescription = "Camera",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = false)
@Composable
fun BottomNavigationPreview() {
    BottomNavigation()
}
