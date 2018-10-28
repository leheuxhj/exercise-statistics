package com.hollyleheux.exercisestatistics.screens.authorization

interface AuthorizationContract {

    interface View {
        fun showText(text: String)
    }

    interface Presenter {
        fun onStart()
    }
}
