package com.hollyleheux.exercisestatistics.screens.authorization

import com.hollyleheux.exercisestatistics.BasePresenter
import timber.log.Timber

class AuthorizationPresenter(
        override val view: AuthorizationContract.View) : BasePresenter<AuthorizationContract.View>(),
    AuthorizationContract.Presenter {

    override fun onStart() {
        Timber.d("AuthorizationPresenter: onStart called")
        view.showText("Authorize me!")
    }
}
