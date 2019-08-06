[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Generic%20Dialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7680)

# RxSplashScreen

Now no need to make a separate SplashScreenActivity in your project. Add the below piece of code in your LoginActivity or SecondActivity after SplashScreen

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
            .setFirstScreen(R.layout.activity_login)
            .setConditionalNavigation(true, object : RxSplashScreenInteraction {
                override fun navigateToSecondScreen(context: Context) {
                    val navigateToCitizen = Intent(context, HomeActivity::class.java)
                    startActivity(navigateToCitizen)
                    finish()
                }
            })
            .splash()
```
## Functions
```
1. setSplashScreen function is used to set the splashscreen layout 
2. setFirstScreen function is used to set the layout of the screen after splashscreen
3. setConditionalNavigation is optional, if you don't use it the navigation will be from splash to first screen. If you use this function, then navigation will be from splash to second screen if token is set true
   e.g.. This is useful if you want to navigate the user from splash to homescreen if the user is logged in

```

[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/P5P810RKM)
