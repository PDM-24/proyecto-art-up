package com.movil.artup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.R
import com.movil.artup.components.BottomNavigation
import com.movil.artup.components.SideMenu
import com.movil.artup.data.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEventScreen(navController: NavController, userViewModel: UserViewModel = viewModel()) {
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
            SideMenu1(navController, onMenuClose = { isSideMenuOpen = false })
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarWithBackground(
                    title = "ART-UP",
                    backgroundImage = R.drawable.fondo_eventos, // replace with your image name
                    onMenuClick = { isSideMenuOpen = !isSideMenuOpen }
                )
            },
            bottomBar = {
                BottomNavigation(
                    onHomeClick = { navController.navigate("perfil") },
                    onAddClick = {
                        /*if (userViewModel.isInstitution) {
                            navController.navigate("editEvent")
                        } else {
                            navController.navigate("sell")
                        }*/
                    }, // Suponiendo que tienes una ruta "add"
                    onMarketClick = { navController.navigate("market") }
                )
            }
        ) { innerPadding ->
            EventEditor(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                institutionName = "Museo Centro"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithBackground(title: String, backgroundImage: Int, onMenuClick: () -> Unit) {
    Box {
        Image(
            painter = painterResource(id = backgroundImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp), // Increased height to ensure image is visible
            contentScale = ContentScale.Crop
        )
        TopAppBar(
            title = {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(title)
                }
            },
            navigationIcon = {
                IconButton(onClick = onMenuClick) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
            },
            actions = {
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { /* User icon click action */ }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "User",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = Color.White,
            ),
            modifier = Modifier.background(Color.Transparent)
        )
    }

}

@Composable
fun EventEditor(modifier: Modifier = Modifier, institutionName: String) {
    val eventName = remember { mutableStateOf("") }
    val eventDate = remember { mutableStateOf("") }
    val eventDescription = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // Center the card in the screen
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp), // Padding outside the card
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(
                modifier = Modifier.padding(16.dp) // Padding inside the card
            ) {
                Text(
                    text = institutionName,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        TextField(
                            value = eventDate.value,
                            onValueChange = { eventDate.value = it },
                            label = { Text("Fecha (dia/mes/año)") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Handle delete event */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                            modifier = Modifier.align(Alignment.Start),
                        ) {
                            Text("Eliminar", color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        TextField(
                            value = eventDescription.value,
                            onValueChange = { eventDescription.value = it },
                            label = { Text("Descripción del evento") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SideMenu1(navController: NavController, onMenuClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) { // Add padding here
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { /* Navegar a Home */ onMenuClose() }) { Text(text = "Home", modifier = Modifier.padding(8.dp)) }
        TextButton(onClick = { /* Navegar a Perfil */ onMenuClose() }) { Text(text = "Perfil", modifier = Modifier.padding(8.dp)) }
        TextButton(onClick = { /* Navegar a Artistas */ onMenuClose() }) { Text(text = "Artistas", modifier = Modifier.padding(8.dp)) }
        TextButton(onClick = { /* Navegar a Market */ onMenuClose() }) { Text(text = "Market", modifier = Modifier.padding(8.dp)) }
        TextButton(onClick = { /* Navegar a Eventos */ onMenuClose() }) { Text(text = "Eventos", modifier = Modifier.padding(8.dp)) }
        TextButton(onClick = { /* Cerrar Sesión */ onMenuClose() }) { Text(text = "Cerrar Sesión", color = Color.Red, modifier = Modifier.padding(8.dp)) }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewEditEvent() {
    val navController = rememberNavController()
    EditEventScreen(navController)
}

