package com.hollyleheux.exercisestatistics.screens.authorization

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hollyleheux.exercisestatistics.R
import com.hollyleheux.exercisestatistics.di.AppComponent
import com.hollyleheux.exercisestatistics.screens.BaseActivity
import com.hollyleheux.exercisestatistics.screens.authorization.di.AuthorizationModule
import kotlinx.android.synthetic.main.activity_authorization.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class AuthorizationActivity : BaseActivity(), AuthorizationContract.View {

    @Inject
    @VisibleForTesting
    lateinit var presenter: AuthorizationPresenter

    override fun loadUrl(urlToLoad: String) {
        authorization_webview.loadUrl(urlToLoad)
    }

    override fun stopLoading() {
        authorization_webview.stopLoading()
    }

    override fun showAuthorizationSuccessMessage() {
        toast(R.string.strava_auth_success_message)
    }

    override fun closeScreen() {
        finish()
    }

    override fun showAuthorizationFailedMessage() {
        toast(R.string.strava_auth_failed_message)
    }

    override fun onStart() {
        super.onStart()
        authorization_webview.webViewClient = StravaAuthWebViewClient()
        presenter.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(AuthorizationModule(this)).inject(this)
    }

    private inner class StravaAuthWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return presenter.overrideUrlLoading(url)
        }
    }
}
