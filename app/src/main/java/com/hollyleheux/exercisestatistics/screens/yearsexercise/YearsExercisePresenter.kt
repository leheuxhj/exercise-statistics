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

    companion object {
        private const val METERS_IN_KILOMETERS = 1000
        private const val YEARS_EXERCISE_PRESENTER_TAG = "YearsExercisePresenter"
    }

    override fun onStart() {
        Timber.d("$YEARS_EXERCISE_PRESENTER_TAG: onStart called")
        when (stravaRepository.hasUserAuthorizedAccessToData()) {
            true -> stravaRepository.getAthleteStats(AthleteStatsSingleObserver().addToCompositeDisposable())
            false -> navigator.navigateToAuthActivity()
        }
    }

    inner class AthleteStatsSingleObserver : DisposableSingleObserver<AthleteStats>() {

        override fun onSuccess(stats: AthleteStats) {
            Timber.d("$YEARS_EXERCISE_PRESENTER_TAG: AthleteStatsSingleObserver $stats")

            if (stats.yearToDateRideTotals?.distanceCovered == 0f
                && stats.yearToDateRunTotals?.distanceCovered == 0f
                && stats.yearToDateSwimTotals?.distanceCovered == 0f) {
                view.showNoExerciseThisYearMessage()
                return
            }

            view.setDistanceExercisedThisYearValuesToChart(
                    distanceRunThisYear = (stats.yearToDateRunTotals?.distanceCovered ?: 0f) / METERS_IN_KILOMETERS,
                    distanceCycledThisYear = (stats.yearToDateRideTotals?.distanceCovered ?: 0f) / METERS_IN_KILOMETERS,
                    distanceSwamThisYear = (stats.yearToDateSwimTotals?.distanceCovered ?: 0f) / METERS_IN_KILOMETERS)
        }

        override fun onError(e: Throwable) {
            Timber.e(e, "$YEARS_EXERCISE_PRESENTER_TAG: AthleteStatsSingleObserver.onError")
        }
    }
}
