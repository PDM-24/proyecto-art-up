package com.movil.artup.navigation

sealed class ScreenRoute(val route: String) {
    data object ProfileScreen  : ScreenRoute("perfil")
    data object ExhibicionScreen : ScreenRoute("exhibicion")
    data object EditProfileScreen : ScreenRoute("editarperfil")
    data object WelcomeScreen : ScreenRoute("welcome")
    data object LoginScreen : ScreenRoute("login")
    data object SignUpScreen : ScreenRoute("signup")
    data object SignUpInstScreen : ScreenRoute("signupinstitucion")
    data object SubscribEvent : ScreenRoute("events")
    data object MarketScreen : ScreenRoute("market")
    data object SellScreen : ScreenRoute("sell")

}
