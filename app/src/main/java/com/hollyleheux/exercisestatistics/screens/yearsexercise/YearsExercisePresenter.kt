package com.hollyleheux.exercisestatistics.screens.yearsexercise

import com.hollyleheux.exercisestatistics.BasePresenter


class YearsExercisePresenter(
        override val view: YearsExerciseContract.View)
    : BasePresenter<YearsExerciseContract.View>(), YearsExerciseContract.Presenter {

    override fun onStart() {
        view.showText("Soo much exercise...")
    }
}
