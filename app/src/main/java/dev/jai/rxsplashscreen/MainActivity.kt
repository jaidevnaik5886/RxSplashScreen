package dev.jai.rxsplashscreen

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.jai.rxsplashscreen2.RxSplashScreen
import dev.jai.rxsplashscreen2.RxSplashScreenInteraction
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxSplashScreen.Builder(this)
            .setSplashScreen(R.layout.activity_splash, 5, TimeUnit.SECONDS)
            .setFirstScreen(R.layout.activity_login)
            .setConditionalNavigation(true, object : RxSplashScreenInteraction {
                override fun navigateToSecondScreen(context: Context) {
                    val navigateToCitizen = Intent(context, HomeActivity::class.java)
                    startActivity(navigateToCitizen)
                    finish()
                }
            })
            .splash()
    }
}
