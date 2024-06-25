package com.movil.artup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import com.movil.artup.navigation.Navigation

@ExperimentalMaterial3Api
class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(this)
        }
    }
}



/*

@SuppressLint("NewApi")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Appp() {
    Navigation(this)
}
*/