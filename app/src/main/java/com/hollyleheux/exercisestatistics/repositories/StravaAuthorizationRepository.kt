package com.hollyleheux.exercisestatistics.repositories

import com.hollyleheux.exercisestatistics.utils.ResourceLocator
import javax.inject.Inject

class StravaAuthorizationRepository @Inject
constructor(private val resourceLocator: ResourceLocator) :
    StravaAuthorizationRepositoryContract {

    companion object {
        private const val STRAVA_AUTH_BASE_URL = "http://www.strava.com/oauth/authorize"
        private const val STRAVA_AUTH_URL_PARAMETERS = "?response_type=code&approval_prompt=force&scope=write"
        private const val STRAVA_AUTH_CLIENT_ID_PARAMETER_NAME = "&client_id="
        private const val REDIRECT_URI_PARAMETER_NAME = "&redirect_uri="
        private const val REDIRECT_URI = "http://localhost/exchange_token"
    }

    override fun getAuthRequestUrl(): String {
        val clientId = resourceLocator.getStringResource(
                ResourceLocator.Strings.KOTLINSTRAVATRIAL_STRAVA_CLIENT_ID)
        return STRAVA_AUTH_BASE_URL + STRAVA_AUTH_URL_PARAMETERS + STRAVA_AUTH_CLIENT_ID_PARAMETER_NAME + clientId +
                REDIRECT_URI_PARAMETER_NAME + REDIRECT_URI
    }
}
