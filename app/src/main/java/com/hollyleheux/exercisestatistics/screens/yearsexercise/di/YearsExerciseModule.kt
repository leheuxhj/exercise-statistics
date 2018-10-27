package com.hollyleheux.exercisestatistics.screens.yearsexercise.di

import com.hollyleheux.exercisestatistics.di.ActivityScope
import com.hollyleheux.exercisestatistics.screens.yearsexercise.YearsExerciseActivity
import com.hollyleheux.exercisestatistics.screens.yearsexercise.YearsExerciseContract
import com.hollyleheux.exercisestatistics.screens.yearsexercise.YearsExercisePresenter
import dagger.Module
import dagger.Provides

@Module
class YearsExerciseModule(val activity: YearsExerciseActivity) {

    @Provides
    @ActivityScope
    fun provideYearsExerciseView(): YearsExerciseContract.View = activity

    @Provides
    @ActivityScope
    fun provideYearsExercisePresenter(view: YearsExerciseContract.View) = YearsExercisePresenter(view)
}
