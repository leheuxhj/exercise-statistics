package com.hollyleheux.exercisestatistics.utils

import android.app.Activity
import android.content.Intent
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationActivity
import timber.log.Timber
import javax.inject.Inject

/**
 * Inject this class into a presenter in order to navigate to another screen.
 */

class Navigator @Inject
internal constructor(private val activity: Activity) {

    fun Intent.start() {
        Timber.d("Starting [%s].", this.component.shortClassName)
        activity.startActivity(this)
    }

    fun navigateToAuthActivity() {
        val intent = Intent(activity, AuthorizationActivity::class.java)
        intent.start()
    }
}
