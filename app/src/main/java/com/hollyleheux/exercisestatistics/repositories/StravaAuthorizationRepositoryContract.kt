package com.hollyleheux.exercisestatistics.repositories

import com.hollyleheux.exercisestatistics.model.StravaAccessToken
import io.reactivex.Single

interface StravaAuthorizationRepositoryContract {

    fun getAuthRequestUrl(): String
    fun getAccessTokenFromStrava(userAuthCode: String): Single<StravaAccessToken>
}
