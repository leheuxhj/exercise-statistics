package com.hollyleheux.exercisestatistics.screens.yearsexercise

import com.hollyleheux.exercisestatistics.model.AthleteStats
import com.hollyleheux.exercisestatistics.repositories.StravaRepository
import com.hollyleheux.exercisestatistics.screens.BasePresenter
import com.hollyleheux.exercisestatistics.utils.Navigator
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber


class YearsExercisePresenter(
        override val view: YearsExerciseContract.View, private val stravaRepository: StravaRepository,
        private val navigator: Navigator)
    : BasePresenter<YearsExerciseContract.View>(), YearsExerciseContract.Presenter {

    override fun onStart() {
        Timber.d("YearsExercisePresenter: onStart called")
        when (stravaRepository.hasUserAuthorizedAccessToData()) {
            true -> stravaRepository.getAthleteStats(AthleteStatsSingleObserver().addToCompositeDisposable())
            false -> navigator.navigateToAuthActivity()
        }
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
