package com.hollyleheux.exercisestatistics.di

import android.content.Context
import com.hollyleheux.exercisestatistics.ExerciseStatisticsApplication
import com.hollyleheux.exercisestatistics.data.local.LocalDataManager
import com.hollyleheux.exercisestatistics.data.local.SharedPreferencesManager
import com.hollyleheux.exercisestatistics.utils.ResourceLocator
import com.hollyleheux.exercisestatistics.utils.ResourceLocatorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(val app: ExerciseStatisticsApplication) {

    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton @ApplicationQualifier fun provideAppContext(): Context = app.applicationContext

    @Provides @Singleton fun provideResourceLocator(): ResourceLocator = ResourceLocatorImpl(app.applicationContext)

    @Provides @Singleton fun providesLocalDataManager(@ApplicationQualifier context: Context): LocalDataManager {
        return SharedPreferencesManager(context)
    }
}
