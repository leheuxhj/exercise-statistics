package com.hollyleheux.exercisestatistics.screens.authorization

import android.net.Uri
import android.util.Patterns
import com.hollyleheux.exercisestatistics.interactors.GetUserAuthorizationAndStoreAccessToken
import com.hollyleheux.exercisestatistics.repositories.StravaRepository
import com.hollyleheux.exercisestatistics.screens.BasePresenter
import io.reactivex.observers.DisposableCompletableObserver
import timber.log.Timber

class AuthorizationPresenter(
        override val view: AuthorizationContract.View,
        private val stravaRepository: StravaRepository,
        private val getUserAuthorizationAndStoreAccessToken: GetUserAuthorizationAndStoreAccessToken) :
    BasePresenter<AuthorizationContract.View>(), AuthorizationContract.Presenter {

    companion object {
        private const val STRAVA_AUTH_HOST_URL = "www.strava.com"
        private const val REDIRECT_HOST_URI = "localhost"
        private const val AUTH_CODE_PARAMETER_NAME = "code"
        private const val AUTHORIZATION_PRESENTER_TAG = "AuthorizationPresenter"
    }

    override fun onStart() {
        val urlString = stravaRepository.getAuthRequestUrl()
        Timber.d("$AUTHORIZATION_PRESENTER_TAG: url to load is $urlString")
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
            Timber.d("$AUTHORIZATION_PRESENTER_TAG: userAuthCode is $userAuthCode")
            getUserAuthorizationAndStoreAccessToken.execute(userAuthCode,
                    UserAuthorizedAndAccessTokenStoredCompletableObserver().addToCompositeDisposable())
        }
    }

    inner class UserAuthorizedAndAccessTokenStoredCompletableObserver : DisposableCompletableObserver() {
        override fun onComplete() {
            Timber.d("$AUTHORIZATION_PRESENTER_TAG: UserAuthorizedAndAccessTokenStoredCompletableObserver.onComplete")
            view.showAuthorizationSuccessMessage()
            view.closeScreen()
        }

        override fun onError(e: Throwable) {
            Timber.e(e, "$AUTHORIZATION_PRESENTER_TAG: UserAuthorizedAndAccessTokenStoredCompletableObserver.onError")
            view.showAuthorizationFailedMessage()
        }
    }
}
