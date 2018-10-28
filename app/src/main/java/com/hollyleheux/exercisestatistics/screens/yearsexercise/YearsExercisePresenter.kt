package com.hollyleheux.exercisestatistics.screens.yearsexercise

import com.hollyleheux.exercisestatistics.model.AthleteStats
import com.hollyleheux.exercisestatistics.repositories.StravaRepository
import com.hollyleheux.exercisestatistics.screens.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber


class YearsExercisePresenter(
        override val view: YearsExerciseContract.View, private val stravaRepository: StravaRepository)
    : BasePresenter<YearsExerciseContract.View>(), YearsExerciseContract.Presenter {

    override fun onStart() {
        Timber.d("YearsExercisePresenter: onStart called")
        stravaRepository.getAthleteStats(AthleteStatsSingleObserver().addToCompositeDisposable())
    }

    inner class AthleteStatsSingleObserver : DisposableSingleObserver<AthleteStats>() {

        override fun onSuccess(stats: AthleteStats) {
            Timber.d("YearsExercisePresenter: AthleteStatsSingleObserver $stats")
        }

        override fun onError(e: Throwable) {
            Timber.e(e, "YearsExercisePresenter: AthleteStatsSingleObserver.onError")
        }
    }
}
