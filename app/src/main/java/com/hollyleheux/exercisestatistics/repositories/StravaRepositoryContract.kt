package com.hollyleheux.exercisestatistics.repositories

import com.hollyleheux.exercisestatistics.model.AthleteStats
import com.hollyleheux.exercisestatistics.model.StravaAccessToken
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

interface StravaRepositoryContract {

    fun getAuthRequestUrl(): String
    fun getAccessTokenFromStrava(userAuthCode: String): Single<StravaAccessToken>
    fun getAthleteStats(singleObserver: DisposableSingleObserver<AthleteStats>)
}
