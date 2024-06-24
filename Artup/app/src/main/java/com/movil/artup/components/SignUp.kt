package com.movil.artup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.movil.artup.R

@Composable
fun SignUpScreen(navController: NavController) {
    val painter = painterResource(id = R.drawable.starry_night)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Image(
            painter = painter,
            contentDescription = "Starry Night",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        ) {
            Text(
                text = "ART-UP",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 32.dp)
        ) {
            Card(


                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { navController.navigate("login") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,
                                contentColor = Color.Black
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Log in")
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(
                            onClick = { navController.navigate("perfil") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF6200EE),
                                contentColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Sign Up")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Bienvenido a Art-up")

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "", // Valor del campo de correo electrónico
                        onValueChange = { /* Actualizar valor del campo */ },
                        label = { Text(text = "Correo electrónico") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "", // Valor del campo de usuario
                        onValueChange = { /* Actualizar valor del campo */ },
                        label = { Text(text = "Usuario") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "", // Valor del campo de contraseña
                        onValueChange = { /* Actualizar valor del campo */ },
                        label = { Text(text = "Contraseña") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { navController.navigate("perfil")  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE),
                            contentColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Sign Up")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Ya tienes una cuenta?",
                        modifier = Modifier.clickable {
                            // Acción a realizar cuando se hace clic en "Ya tienes una cuenta?"
                            navController.navigate("login") // Por ejemplo, navegar a la pantalla de inicio de sesión
                        }
                    )

                }
            }
        }
    }
}




