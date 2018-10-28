package com.hollyleheux.exercisestatistics.screens.yearsexercise

import com.hollyleheux.exercisestatistics.model.AthleteStats
import com.hollyleheux.exercisestatistics.repositories.StravaRepository
import com.hollyleheux.exercisestatistics.utils.Navigator
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.Random


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YearsExercisePresenterTest {

    private val view: YearsExerciseContract.View = mockk(relaxed = true)
    private val stravaRepository: StravaRepository = mockk(relaxed = true)
    private val navigator: Navigator = mockk(relaxed = true)
    private lateinit var presenter: YearsExercisePresenter

    @BeforeEach
    fun init() {
        clearMocks(view, stravaRepository, navigator)
        presenter = YearsExercisePresenter(view, stravaRepository, navigator)
    }

    @Nested
    inner class onStart {

        @Test
        fun hasUserAuthorizedAccessToData() {
            presenter.onStart()

            verify {
                stravaRepository.hasUserAuthorizedAccessToData()
            }
        }

        @Test
        fun hasUserAuthorizedAccessToData_TRUE_getAthleteStats() {
            every { stravaRepository.hasUserAuthorizedAccessToData() } returns true
            presenter.onStart()

            verify {
                stravaRepository.getAthleteStats(any<YearsExercisePresenter.AthleteStatsSingleObserver>())
            }
        }

        @Test
        fun hasUserAuthorizedAccessToData_FALSE_navigateToAuthActivity() {
            every { stravaRepository.hasUserAuthorizedAccessToData() } returns false
            presenter.onStart()

            verify {
                navigator.navigateToAuthActivity()
            }
        }
    }

    @Nested
    inner class AthleteStatsSingleObserver {

        @Test
        fun onSuccess_setDistanceExercisedThisYearValuesToChart() {
            val athleteStats = getRandomAthleteStats()
            presenter.AthleteStatsSingleObserver().onSuccess(athleteStats)

            verify {
                view.setDistanceExercisedThisYearValuesToChart(
                        distanceRunThisYear = (athleteStats.yearToDateRunTotals!!.distanceCovered) / 1000,
                        distanceCycledThisYear = (athleteStats.yearToDateRideTotals!!.distanceCovered) / 1000,
                        distanceSwamThisYear = (athleteStats.yearToDateSwimTotals!!.distanceCovered) / 1000)
            }
        }

        @Test
        fun onSuccess_showNoExerciseThisYearMessage() {
            val athleteStats = getEmptyAthleteStats()
            presenter.AthleteStatsSingleObserver().onSuccess(athleteStats)

            verify {
                view.showNoExerciseThisYearMessage()
            }
        }
    }

    private fun getRandomAthleteStats(): AthleteStats {
        return AthleteStats(yearToDateRideTotals = getRandomActivitySetMetrics(),
                yearToDateRunTotals = getRandomActivitySetMetrics(),
                yearToDateSwimTotals = getRandomActivitySetMetrics())
    }

    private fun getRandomActivitySetMetrics(): AthleteStats.ActivitySetMetrics {
        return AthleteStats.ActivitySetMetrics(activityCount = Random().nextInt(70),
                distanceCovered = Random().nextFloat(), movingTime = Random().nextInt(70),
                elevationGain = Random().nextFloat(), achievementCount = Random().nextInt(70),
                elapsedTime = Random().nextInt(70))
    }

    private fun getEmptyAthleteStats(): AthleteStats {
        return AthleteStats(yearToDateRideTotals = getEmptyActivitySetMetrics(),
                yearToDateRunTotals = getEmptyActivitySetMetrics(),
                yearToDateSwimTotals = getEmptyActivitySetMetrics())
    }

    private fun getEmptyActivitySetMetrics(): AthleteStats.ActivitySetMetrics {
        return AthleteStats.ActivitySetMetrics(activityCount = 0, distanceCovered = 0f, movingTime = 0,
                elevationGain = 0f, achievementCount = 0, elapsedTime = 0)
    }
}
