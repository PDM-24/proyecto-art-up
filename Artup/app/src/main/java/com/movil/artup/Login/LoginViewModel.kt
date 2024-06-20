package com.movil.artup.Login

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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



   fun getCurrentUser(): FirebaseUser?{
      return auth.currentUser
   }



}