package com.hollyleheux.exercisestatistics.utils

import android.content.Context
import android.support.annotation.StringRes
import com.hollyleheux.exercisestatistics.R
import javax.inject.Inject

class ResourceLocatorImpl @Inject
internal constructor(private val context: Context) : ResourceLocator() {

    override fun getStringResource(stringResource: Strings): String {
        @StringRes val stringResId = when (stringResource) {
            ResourceLocator.Strings.KOTLINSTRAVATRIAL_STRAVA_CLIENT_ID -> R.string.kotlinstravatrial_strava_client_id
        }
        return getString(stringResId)
    }

    private fun getString(@StringRes stringResId: Int): String {
        return context.getString(stringResId)
    }
}
