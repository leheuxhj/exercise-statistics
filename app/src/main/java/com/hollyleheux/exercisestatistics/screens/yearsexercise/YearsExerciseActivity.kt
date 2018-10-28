package com.hollyleheux.exercisestatistics.screens.yearsexercise

import android.content.Intent
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import com.hollyleheux.exercisestatistics.screens.BaseActivity
import com.hollyleheux.exercisestatistics.R
import com.hollyleheux.exercisestatistics.di.AppComponent
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationActivity
import com.hollyleheux.exercisestatistics.screens.yearsexercise.di.YearsExerciseModule
import kotlinx.android.synthetic.main.activity_years_exercise.*
import javax.inject.Inject

class YearsExerciseActivity : BaseActivity(), YearsExerciseContract.View {

    @Inject
    @VisibleForTesting
    lateinit var presenter: YearsExercisePresenter

    override fun showText(text: String) {
        years_exercise_text.text = text
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
        years_exercise_button.setOnClickListener { gotoAuthActivity() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_years_exercise)
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(YearsExerciseModule(this)).inject(this)
    }

    private fun gotoAuthActivity(){
        val intent = Intent(this, AuthorizationActivity::class.java)
        startActivity(intent)
    }
}
