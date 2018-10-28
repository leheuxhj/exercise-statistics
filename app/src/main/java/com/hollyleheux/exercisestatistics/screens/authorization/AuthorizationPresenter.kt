package com.hollyleheux.exercisestatistics.screens.authorization

import android.net.Uri
import android.util.Patterns
import com.hollyleheux.exercisestatistics.BasePresenter
import com.hollyleheux.exercisestatistics.repositories.StravaAuthorizationRepository
import timber.log.Timber

class AuthorizationPresenter(
        override val view: AuthorizationContract.View,
        private val stravaAuthorizationRepository: StravaAuthorizationRepository) :
    BasePresenter<AuthorizationContract.View>(), AuthorizationContract.Presenter {

    companion object {
        private const val STRAVA_AUTH_HOST_URL = "www.strava.com"
        private const val REDIRECT_HOST_URI = "localhost"
        private const val AUTH_CODE_PARAMETER_NAME = "code"
    }

    override fun onStart() {
        val urlString = stravaAuthorizationRepository.getAuthRequestUrl()
        Timber.d("AuthorizationPresenter: url to load is $urlString")
        if (Patterns.WEB_URL.matcher(urlString).matches()) view.loadUrl(urlString)
    }

    override fun overrideUrlLoading(url: String?): Boolean {
        return when (Uri.parse(url).host) {
            AuthorizationPresenter.STRAVA_AUTH_HOST_URL -> false
            AuthorizationPresenter.REDIRECT_HOST_URI -> {
                view.stopLoading()
                handleRedirectHostUri(url)
                false
            }
            else -> true
        }
    }

    private fun handleRedirectHostUri(uri: String?) {
        if (uri != null) {
            val userAuthCode = Uri.parse(uri).getQueryParameter(AuthorizationPresenter.AUTH_CODE_PARAMETER_NAME)
            Timber.d("AuthorizationPresenter: userAuthCode is $userAuthCode")
        }
    }
}
