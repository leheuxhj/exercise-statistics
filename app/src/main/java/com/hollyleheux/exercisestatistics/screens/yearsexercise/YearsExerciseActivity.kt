package com.hollyleheux.exercisestatistics.screens.yearsexercise

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.view.View
import com.hollyleheux.exercisestatistics.R
import com.hollyleheux.exercisestatistics.di.AppComponent
import com.hollyleheux.exercisestatistics.screens.BaseActivity
import com.hollyleheux.exercisestatistics.screens.yearsexercise.di.YearsExerciseModule
import kotlinx.android.synthetic.main.activity_years_exercise.*
import org.eazegraph.lib.models.PieModel
import org.jetbrains.anko.toast
import javax.inject.Inject

class YearsExerciseActivity : BaseActivity(), YearsExerciseContract.View {

    @Inject
    @VisibleForTesting
    lateinit var presenter: YearsExercisePresenter

    override fun setDistanceExercisedThisYearValuesToChart(distanceRunThisYear: Float, distanceCycledThisYear: Float,
            distanceSwamThisYear: Float) {
        exercise_this_year_piechart.addPieSlice(PieModel(getString(R.string.running), distanceRunThisYear,
                resources.getColor(R.color.chart_color_pink)))
        exercise_this_year_piechart.addPieSlice(PieModel(getString(R.string.cycling), distanceCycledThisYear,
                resources.getColor(R.color.chart_color_blue)))
        exercise_this_year_piechart.addPieSlice(PieModel(getString(R.string.swimming), distanceSwamThisYear,
                resources.getColor(R.color.chart_color_brown)))

        exercise_this_year_piechart.startAnimation()
        exercise_this_year_piechart.innerValueUnit = getString(R.string.kilometer_unit)
    }

    override fun showNoExerciseThisYearMessage() {
        exercise_this_year_piechart.visibility = View.GONE
        toast(R.string.no_exercise_message)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_years_exercise)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(YearsExerciseModule(this)).inject(this)
    }
}
