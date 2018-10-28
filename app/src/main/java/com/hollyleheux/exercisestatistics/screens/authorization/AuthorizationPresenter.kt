package com.hollyleheux.exercisestatistics.screens.authorization

import com.hollyleheux.exercisestatistics.BasePresenter
import com.hollyleheux.exercisestatistics.repositories.StravaAuthorizationRepository
import timber.log.Timber

class AuthorizationPresenter(
        override val view: AuthorizationContract.View,
        private val stravaAuthorizationRepository: StravaAuthorizationRepository) :
    BasePresenter<AuthorizationContract.View>(), AuthorizationContract.Presenter {

    override fun onStart() {
        Timber.d("AuthorizationPresenter: onStart called")
        view.showText(stravaAuthorizationRepository.getAuthRequestUrl())
    }
}
