package com.hollyleheux.exercisestatistics.utils

abstract class ResourceLocator {

    abstract fun getStringResource(stringResource: Strings): String

    enum class Strings {
        KOTLINSTRAVATRIAL_STRAVA_CLIENT_ID,
        STRAVA_CLIENT_SECRET
    }
}
