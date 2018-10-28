package com.hollyleheux.exercisestatistics.screens.authorization

interface AuthorizationContract {

    interface View {
        fun loadUrl(urlToLoad: String)
        fun stopLoading()
        fun showAuthorizationSuccessMessage()
        fun closeScreen()
        fun showAuthorizationFailedMessage()
    }

    interface Presenter {
        fun onStart()
        fun overrideUrlLoading(url: String?): Boolean
    }
}
