package com.hollyleheux.exercisestatistics.screens.authorization

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import com.hollyleheux.exercisestatistics.BaseActivity
import com.hollyleheux.exercisestatistics.R
import com.hollyleheux.exercisestatistics.di.AppComponent
import com.hollyleheux.exercisestatistics.screens.authorization.di.AuthorizationModule
import kotlinx.android.synthetic.main.activity_authorization.*
import javax.inject.Inject

class AuthorizationActivity : BaseActivity(), AuthorizationContract.View {

    @Inject
    @VisibleForTesting
    lateinit var presenter: AuthorizationPresenter

    override fun showText(text: String) {
        authorization_text.text = text
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(AuthorizationModule(this)).inject(this)
    }
}
