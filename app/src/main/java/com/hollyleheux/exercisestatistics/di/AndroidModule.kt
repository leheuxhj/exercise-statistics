package com.hollyleheux.exercisestatistics.di

import android.content.Context
import com.hollyleheux.exercisestatistics.ExerciseStatisticsApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(val app: ExerciseStatisticsApplication) {

    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton @ApplicationQualifier fun provideAppContext(): Context = app.applicationContext
}
