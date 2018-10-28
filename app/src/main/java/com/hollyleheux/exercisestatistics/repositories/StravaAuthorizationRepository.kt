package com.hollyleheux.exercisestatistics.repositories

import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenRequest
import com.hollyleheux.exercisestatistics.data.mappers.StravaMapper
import com.hollyleheux.exercisestatistics.data.network.StravaService
import com.hollyleheux.exercisestatistics.model.StravaAccessToken
import com.hollyleheux.exercisestatistics.utils.ResourceLocator
import io.reactivex.Single
import javax.inject.Inject

class StravaAuthorizationRepository @Inject
constructor(private val resourceLocator: ResourceLocator, private val stravaService: StravaService,
        private val stravaMapper: StravaMapper) : StravaAuthorizationRepositoryContract {

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

    override fun getAccessTokenFromStrava(userAuthCode: String): Single<StravaAccessToken> {
        val stravaAccessTokenRequest = StravaAccessTokenRequest(
                clientId = resourceLocator.getStringResource(
                        ResourceLocator.Strings.KOTLINSTRAVATRIAL_STRAVA_CLIENT_ID),
                code = userAuthCode,
                clientSecret = resourceLocator.getStringResource(ResourceLocator.Strings.STRAVA_CLIENT_SECRET))
        return stravaService.getAccessToken(stravaAccessTokenRequest).map { stravaMapper.map(it) }
    }
}
