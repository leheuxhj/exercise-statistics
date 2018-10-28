package com.hollyleheux.exercisestatistics.screens.yearsexercise

interface YearsExerciseContract {

    interface View {
        fun setDistanceExercisedThisYearValuesToChart(distanceRunThisYear: Float, distanceCycledThisYear: Float,
                distanceSwamThisYear: Float)

        fun showNoExerciseThisYearMessage()
    }

    interface Presenter {
        fun onStart()
    }
}
