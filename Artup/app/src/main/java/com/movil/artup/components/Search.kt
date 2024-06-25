package com.movil.artup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movil.artup.R

@Composable
fun SearchHeader(
    onBurgerClick: () -> Unit = {},
    onSearchClick: (String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

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

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray, shape = TextFieldDefaults.outlinedShape)
                .height(56.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                placeholder = {
                    Text(text = "Escriba el nombre de usuario", fontSize = 14.sp)
                },
                modifier = Modifier.fillMaxSize(),

                singleLine = true,
                trailingIcon = {
                    IconButton(
                        onClick = { onSearchClick(searchText.text) },
                        modifier = Modifier.size(24.dp) // Ajustar tamaño del icono de búsqueda aquí
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifying_glass_solid),
                            contentDescription = "Search",
                            modifier = Modifier.size(18.dp) // Ajustar tamaño del icono de búsqueda aquí
                        )
                    }
                }
            )
        }
    }
}
