package com.hollyleheux.exercisestatistics.di

import com.hollyleheux.exercisestatistics.ExerciseStatisticsApplication
import com.hollyleheux.exercisestatistics.screens.yearsexercise.di.YearsExerciseComponent
import com.hollyleheux.exercisestatistics.screens.yearsexercise.di.YearsExerciseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidModule::class)])
interface AppComponent {
    fun inject(app: ExerciseStatisticsApplication)
    fun plus(yearsExerciseModule: YearsExerciseModule): YearsExerciseComponent
}
