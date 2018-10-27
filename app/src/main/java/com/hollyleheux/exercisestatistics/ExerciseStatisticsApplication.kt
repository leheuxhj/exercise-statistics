package com.hollyleheux.exercisestatistics

import android.app.Application
import com.hollyleheux.exercisestatistics.di.AndroidModule
import com.hollyleheux.exercisestatistics.di.AppComponent
import com.hollyleheux.exercisestatistics.di.DaggerAppComponent
import timber.log.Timber

class ExerciseStatisticsApplication : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDaggerAppComponent()
        initializeTimber()
    }

    private fun initializeDaggerAppComponent() {
        component = DaggerAppComponent
                .builder()
                .androidModule(AndroidModule(this))
                .build()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
