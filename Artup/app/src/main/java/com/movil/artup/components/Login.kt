package com.movil.artup.components


import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.movil.artup.Login.LoginViewModel
import com.movil.artup.R
import com.movil.artup.navigation.ScreenRoute


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel=androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val painter = painterResource(id = R.drawable.starry_night)
     val token = "1043175033408-8437errdombsjq27174c5h4d6cl865gp.apps.googleusercontent.com"
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts
                  .StartActivityForResult()

    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken,null)
            viewModel.signInWhitGoogle(credential){
                navController.navigate(ScreenRoute.ExhibicionScreen.route)
            }
        }catch(ex: Exception){
            Log.d("Problema","No se pudo")
        }
    }
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
                    Text(text = "Bienvenido a Art-up")

                    Spacer(modifier = Modifier.height(16.dp))

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
                        onClick = { /* Acción de inicio de sesión */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE),
                            contentColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Log in")
                    }

                   Row (
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp)
                           .clip(RoundedCornerShape(10.dp))
                           .clickable{
                                     val opciones = GoogleSignInOptions.Builder(
                                         GoogleSignInOptions.DEFAULT_SIGN_IN
                                     )
                                         .requestIdToken(token)
                                         .requestEmail()
                                         .build()
                               val googleClient = GoogleSignIn.getClient(context,opciones)
                              launcher.launch(googleClient.signInIntent)
                                     },
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.Center
                   ){

                       Image(painter = painterResource(id = R.drawable.google),
                           contentDescription = "Login with Google",
                           modifier = Modifier
                               .padding(10.dp)
                               .size(40.dp)
                           )

                       Text(text="Login with Google",
                          fontSize = 18.sp,
                          fontWeight = FontWeight.Bold
                       )

                   }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "No tienes cuenta? Registrarse",
                        color = Color.Blue,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable { navController.navigate("signup") }
                    )
                }
            }
        }
    }
}

