package com.hollyleheux.exercisestatistics.data.local

import io.reactivex.Completable

interface LocalDataManager {
    fun getStravaAccessToken(): String?
    fun setStravaAccessToken(accessToken: String): Completable
    fun setStravaAthleteId(athleteId: Int): Completable
    fun getStravaAthleteId(): Int?
}
