package com.movil.artup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movil.artup.Publication
import android.content.ContentResolver
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.movil.artup.components.BottomNavigation

/**
 * Convierte una Uri en un ImageBitmap para ser usado con Compose.
 */
@Composable
fun imageResourceUri(contentResolver: ContentResolver, uri: Uri): ImageBitmap {
    val inputStream = contentResolver.openInputStream(uri)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    return bitmap?.asImageBitmap() ?: ImageBitmap(1, 1) // Manejo de caso nulo o error
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketIndividualScreen(navController: NavController, publication: Publication) {
    var isSideMenuOpen by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    LaunchedEffect(isSideMenuOpen) {
        if (isSideMenuOpen) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            SideMenu(navController, onMenuClose = { isSideMenuOpen = false })
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Market") },
                    navigationIcon = {
                        IconButton(onClick = { isSideMenuOpen = !isSideMenuOpen }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black,
                        navigationIconContentColor = Color.Black,
                        actionIconContentColor = Color.Black
                    )
                )
            },
            bottomBar = {
                BottomNavigation(
                    onHomeClick = { navController.navigate("perfil") },
                    onAddClick = { navController.navigate("add") },
                    onMarketClick = { navController.navigate("market") }
                )
            },
            content = { padding ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)) {

                    val imageBitmap = imageResourceUri(LocalContext.current.contentResolver, publication.imageRes)
                    Image(
                        bitmap = imageBitmap,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = publication.username,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = publication.price,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    // Add to cart button or any other actions can be added here
                }
            }
        )
    }
}
