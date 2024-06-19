// src/main/kotlin/com/movil/artup/components/HeaderProfile.kt
package com.movil.artup.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movil.artup.R

@Composable
fun HeaderProfile(
    navController: NavController,
    onBurgerClick: () -> Unit = {},
    username: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = onBurgerClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bars_solid),
                contentDescription = "Open Side Menu"
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { navController.navigate("search") },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.magnifying_glass_solid),
                contentDescription = "Search"
            )
        }
    }
}
