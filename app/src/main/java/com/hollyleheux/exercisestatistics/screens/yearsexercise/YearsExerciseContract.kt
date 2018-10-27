package com.hollyleheux.exercisestatistics.screens.yearsexercise

interface YearsExerciseContract {

    interface View {
        fun showText(text: String)
    }

    interface Presenter {
        fun onStart()
    }
}
