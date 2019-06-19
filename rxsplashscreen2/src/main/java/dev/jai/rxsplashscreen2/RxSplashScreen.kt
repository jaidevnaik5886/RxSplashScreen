package dev.jai.rxsplashscreen2

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Timed
import java.util.concurrent.TimeUnit


class RxSplashScreen private constructor(builder: Builder) {
    private var splashLayout: Int = 0
    private var token: Boolean = false
    private var period: Long = 1
    private var timeUnit: TimeUnit = TimeUnit.SECONDS
    private var rxSplashInteraction: RxSplashScreenInteraction?

    init {
        this.splashLayout = builder.splashLayout
        this.period = builder.period
        this.timeUnit = builder.timeUnit
        this.token = builder.token
        this.rxSplashInteraction = builder.rxSplashInteraction
    }

    class Builder(private val context: Context) {
        internal var splashLayout: Int = 0
        internal var firstScreen: Int = 0
        internal var token: Boolean = false
        internal var period: Long = 1
        internal var timeUnit: TimeUnit = TimeUnit.SECONDS
        var rxSplashInteraction: RxSplashScreenInteraction? = null

        fun splash(): RxSplashScreen {
            val activity = context as Activity
            if (splashLayout != 0) activity.setContentView(splashLayout)
            Observable.interval(period, timeUnit).timeInterval()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Timed<Long>>() {
                    override fun onComplete() {}
                    override fun onNext(data: Timed<Long>) {
                        dispose()
                        if (!token) {
                            if (firstScreen != 0) {
                                activity.setContentView(firstScreen)
                            }
                        } else {
                            rxSplashInteraction?.navigateToSecondScreen(context)
                        }
                    }

                    override fun onError(e: Throwable) {
                    }
                })
            return RxSplashScreen(this)
        }

        fun setSplashScreen(@LayoutRes splashLayout: Int, period: Long, timeUnit: TimeUnit): Builder {
            this.splashLayout = splashLayout
            this.period = period
            this.timeUnit = timeUnit
            return this
        }

        fun setFirstScreen(@LayoutRes firstScreen: Int): Builder {
            this.firstScreen = firstScreen
            return this
        }

        fun setConditionalNavigation(token: Boolean, rxSplashInteraction: RxSplashScreenInteraction): Builder {
            this.token = token
            this.rxSplashInteraction = rxSplashInteraction
            return this
        }


    }
}