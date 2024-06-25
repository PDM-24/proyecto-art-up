package com.movil.artup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.movil.artup.components.BottomNavigation

data class Event(val title: String, val date: String, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    val availableEvents = remember {
        mutableStateListOf(
            Event(
                "Museo Marte",
                "21 de mayo 2024",
                "Exposicion de obras de arte estudiantes de universidad Jose Simeon Canas"
            ),
            Event(
                "Museo Centro",
                "14 de junio de 2024",
                "Exposicion de diseno de moda universidad Jose Matias Delgado"
            ),
            Event(
                "Museo Centro",
                "14 de junio de 2024",
                "Exposicion de diseno de moda universidad Jose Matias Delgado"
            )
        )
    }
    val subscribedEvents = remember { mutableStateListOf<Event>() }
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
                    title = { Text("ART-UP") },
                    colors = TopAppBarDefaults.topAppBarColors(Color.White),
                    modifier = Modifier.background(Color.Black),
                    navigationIcon = {
                        IconButton(onClick = { isSideMenuOpen = !isSideMenuOpen }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                )
            },
            bottomBar = {
                BottomNavigation(
                    onHomeClick = { navController.navigate("perfil") },
                    onAddClick = { navController.navigate("sell") },
                    onMarketClick = { navController.navigate("market") }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    TabRow(selectedTabIndex = selectedTab) {
                        Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                            Text("Eventos", modifier = Modifier.padding(16.dp))
                        }
                        Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
                            Text(
                                "Suscrito",
                                modifier = Modifier.padding(16.dp),
                                color = Color.Black
                            )
                        }
                    }

                    when (selectedTab) {
                        0 -> EventList(events = availableEvents, onSubscribeClick = { event ->
                            availableEvents.remove(event)
                            subscribedEvents.add(event)
                        })

                        1 -> EventList(events = subscribedEvents, onUnsubscribeClick = { event ->
                            subscribedEvents.remove(event)
                            availableEvents.add(event)
                        })
                    }
                }
            }
        )
    }
}

@Composable
fun EventList(events: List<Event>, onSubscribeClick: ((Event) -> Unit)? = null, onUnsubscribeClick: ((Event) -> Unit)? = null) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(events) { event ->
            EventCard(event, onSubscribeClick, onUnsubscribeClick)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun EventCard(event: Event, onSubscribeClick: ((Event) -> Unit)?, onUnsubscribeClick: ((Event) -> Unit)?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = event.title,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = event.date,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.description,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (onSubscribeClick != null) {
                Button(
                    onClick = { onSubscribeClick(event) },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Inscribirme")
                }
            } else if (onUnsubscribeClick != null) {
                Button(
                    onClick = { onUnsubscribeClick(event) },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Desuscribirme")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    EventScreen(navController)
}

