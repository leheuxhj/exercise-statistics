package com.hollyleheux.exercisestatistics.screens.yearsexercise.di

import com.hollyleheux.exercisestatistics.di.ActivityScope
import com.hollyleheux.exercisestatistics.screens.yearsexercise.YearsExerciseActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(YearsExerciseModule::class))
interface YearsExerciseComponent {
    fun inject(activity: YearsExerciseActivity)
}
