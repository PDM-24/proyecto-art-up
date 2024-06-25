package com.movil.artup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.R
import com.movil.artup.components.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    var isSideMenuOpen by remember { mutableStateOf(false) }
    var searchResults by remember { mutableStateOf(listOf("melanyg98", "fabriziocalderon", "fernandocrz", "vanessatgh", "melanyytgs")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Search") },
                navigationIcon = {
                    IconButton(onClick = { isSideMenuOpen = !isSideMenuOpen }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = "",
                            onValueChange = { /* Lógica de búsqueda basada en query */ },
                            placeholder = { Text(text = "Escribe el nombre de usuario") },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                        )
                        IconButton(onClick = { /* Acción de búsqueda */ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                        }
                    }
                }
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
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Search",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(searchResults) { result ->
                            Column {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.user),
                                        contentDescription = "User Icon",
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Text(text = result, fontSize = 25.sp)
                                }
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun VistaSearch() {
    SearchScreen(navController = rememberNavController())
}
