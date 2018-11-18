package com.hollyleheux.exercisestatistics.di

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    @ActivityScope
    fun provideActiviyContext(): Context = activity.baseContext
}
