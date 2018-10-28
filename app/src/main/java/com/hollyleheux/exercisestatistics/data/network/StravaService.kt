package com.hollyleheux.exercisestatistics.data.network

import com.hollyleheux.exercisestatistics.data.entities.AthleteEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface StravaService {

    companion object {
        private const val AUTH_HEADER = "Authorization"
    }

    @POST("oauth/token")
    fun getAccessToken(@Body stravaAccessTokenRequest: StravaAccessTokenRequest): Single<StravaAccessTokenEntity>

    @GET("api/v3/athlete")
    fun getAthlete(@Header(AUTH_HEADER) token: String): Single<AthleteEntity>

}
