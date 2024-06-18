package com.movil.artup.Login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

private val auth: FirebaseAuth = Firebase.auth
   fun signInWhitGoogle(credential:AuthCredential,home:()->Unit)= viewModelScope.launch{
      try {
          auth.signInWithCredential(credential)
             .addOnCompleteListener{ task->
                if(task.isSuccessful){
                   home()
                }
             }
             .addOnFailureListener{
                Log.d("","Error")
             }
      }catch(ex:Exception){
         Log.d("e",ex.localizedMessage.toString())
      }
   }
}