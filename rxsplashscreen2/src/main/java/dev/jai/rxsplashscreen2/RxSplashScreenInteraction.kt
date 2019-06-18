package dev.jai.rxsplashscreen2

import android.content.Context

interface RxSplashScreenInteraction {

    fun navigateToLoginScreen()
    fun navigateToHomeScreen(context: Context)

}