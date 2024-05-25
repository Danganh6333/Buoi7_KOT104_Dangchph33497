package com.dangchph33497.fpoly.buoi7_kot104.navigation

enum class Screen {
    SPLASH,
    SIGN_IN,
    SIGN_UP,
    BOTTOM,
    CONGRATULATION,
    HOME,
    BOOKMARK,
    NOTIFICATION,
    PROFILE
}

sealed class Screens(val route : String) {
    object Splash : Screens(Screen.SPLASH.name)
    object SignIn : Screens(Screen.SIGN_IN.name)
    object SignUp : Screens(Screen.SIGN_UP.name)
    object Bottom : Screens(Screen.BOTTOM.name)
    object Congratulation : Screens(Screen.CONGRATULATION.name)
    object Home : Screens(Screen.HOME.name)
    object Bookmark : Screens(Screen.BOOKMARK.name)
    object Notification : Screens(Screen.NOTIFICATION.name)
    object Profile : Screens(Screen.PROFILE.name)
}