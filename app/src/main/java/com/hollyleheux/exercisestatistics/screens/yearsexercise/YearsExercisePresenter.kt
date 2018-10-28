package com.hollyleheux.exercisestatistics.screens.yearsexercise

import com.hollyleheux.exercisestatistics.screens.BasePresenter
import timber.log.Timber


class YearsExercisePresenter(
        override val view: YearsExerciseContract.View)
    : BasePresenter<YearsExerciseContract.View>(), YearsExerciseContract.Presenter {

    override fun onStart() {
        Timber.d("YearsExercisePresenter: onStart called")
        view.showText("Soo much exercise...")
    }
}
