package com.hollyleheux.exercisestatistics.screens

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hollyleheux.exercisestatistics.ExerciseStatisticsApplication
import com.hollyleheux.exercisestatistics.di.AppComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(ExerciseStatisticsApplication.component)
    }

    abstract fun injectDependencies(appComponent: AppComponent)
}
