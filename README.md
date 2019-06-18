# RxSplashScreen

Now no need to make a separate SplashScreenActivity in your project. Add the below piece of code in your loginActivity or SecondActivity after SplashScreen

## Getting Started
## Installation
Add this into your root build.gradle file:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency to your module build.gradle:
```
implementation 'com.github.jaidevnaik5886:RxSplashScreen:1.0'

```
## Usage 
```
       RxSplashScreen.Builder(this)
            .setSplashScreen(R.layout.activity_splash, 5, TimeUnit.SECONDS)
            .setAuthenticationCheckValue(false)
            .navigate(object : RxSplashScreenInteraction {
                override fun navigateToLoginScreen() {
                    setContentView(R.layout.activity_login)
                }
                override fun navigateToHomeScreen(context: Context) {
                    val navigateToCitizen = Intent(context, HomeActivity::class.java)
                    startActivity(navigateToCitizen)
                    finish()
                }
            })
            .splash()
```


