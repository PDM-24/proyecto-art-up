package com.movil.artup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.movil.artup.Publication
import com.movil.artup.R
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.SideMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchasesScreen(navController: NavController, publications: List<Publication>) {
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
                    title = { Text(text = "") },
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
                    onAddClick = { navController.navigate("add") }, // Suponiendo que tienes una ruta "add"
                    onMarketClick = { navController.navigate("market") }
                )
            },
            content = { padding ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Cart",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(16.dp),
                                tint = Color.Black
                            )
                            Text(text = "Purchase", fontSize = 20.sp, color = Color.Black)
                        }
                    }

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(publications) { publication ->
                            PublicationItem(publication)
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun PublicationItem(publication: Publication) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                // Handle click event to navigate to detailed post or show a message
            }
    ) {
        Text(text = publication.username, fontSize = 12.sp, modifier = Modifier.fillMaxWidth())
        Image(
            painter = rememberAsyncImagePainter(model = publication.imageRes),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = publication.price, fontSize = 16.sp, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun SideMenu(navController: NavController, onMenuClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { /* Navegar a Home */ onMenuClose() }) { Text(text = "Home") }
        TextButton(onClick = { /* Navegar a Perfil */ onMenuClose() }) { Text(text = "Perfil") }
        TextButton(onClick = { /* Navegar a Artistas */ onMenuClose() }) { Text(text = "Artistas") }
        TextButton(onClick = { /* Navegar a Market */ onMenuClose() }) { Text(text = "Market") }
        TextButton(onClick = { /* Navegar a Eventos */ onMenuClose() }) { Text(text = "Eventos") }
        TextButton(onClick = { /* Cerrar Sesión */ onMenuClose() }) { Text(text = "Cerrar Sesión", color = Color.Red) }
    }
}

@Composable
fun BottomNavigationBar(onHomeClick: () -> Unit, onAddClick: () -> Unit, onMarketClick: () -> Unit) {
    BottomAppBar(
        containerColor = Color.DarkGray,
        contentColor = Color.White
    ) {
        IconButton(onClick = onHomeClick) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = onAddClick) {
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = onMarketClick) {
            Icon(
                painter = painterResource(id = R.drawable.store_solid),
                contentDescription = "Custom Icon",
                modifier = Modifier.size(24.dp) // Adjust size as needed
            )
        }
    }
}


