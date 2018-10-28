package com.hollyleheux.exercisestatistics.data.network

import com.hollyleheux.exercisestatistics.data.entities.AthleteStatsEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface StravaService {

    companion object {
        private const val AUTH_HEADER = "Authorization"
    }

    @POST("oauth/token")
    fun getAccessToken(@Body stravaAccessTokenRequest: StravaAccessTokenRequest): Single<StravaAccessTokenEntity>

    @GET("api/v3/athletes/{athlete_id}/stats")
    fun getAthleteStats(@Header(AUTH_HEADER) token: String,
            @Path("athlete_id") athleteId: Int): Single<AthleteStatsEntity>

}
