package com.movil.artup.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movil.artup.R

@ExperimentalMaterial3Api
@Composable
fun EditProfile(
    navController: NavController
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var avatarResId by remember { mutableStateOf(R.drawable.artwork3) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Perfil") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.circle_plus_solid),
                    contentDescription = "Edit Icon",
                    modifier = Modifier.size(24.dp)
                        .clickable{/*logica para cambiar foto de perfil*/}
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = avatarResId),
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Usuario") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    //logica para actualizar datos
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Actualizar")
            }
        }
    }
}


