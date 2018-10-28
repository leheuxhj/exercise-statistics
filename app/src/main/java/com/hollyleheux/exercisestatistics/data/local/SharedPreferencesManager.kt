package com.hollyleheux.exercisestatistics.data.local

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Provides
import io.reactivex.Completable

class SharedPreferencesManager(context: Context): LocalDataManager {

    companion object {
        const val KEY_PREFIX = "hollyleheux.kotlinstravatrial."
        const val KEY_STRAVA_ATHLETE_ID = KEY_PREFIX + "strava_athlete_id"
        const val KEY_STRAVA_ACCESS_TOKEN = KEY_PREFIX + "strava_access_token"
    }

    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getStravaAccessToken(): String? {
        return sharedPreferences.getString(
                KEY_STRAVA_ACCESS_TOKEN, null)
    }

    override fun setStravaAccessToken(accessToken: String): Completable {
        return Completable.fromAction {
            sharedPreferences.edit().putString(
                    KEY_STRAVA_ACCESS_TOKEN, accessToken).apply()
        }
    }

    override fun setStravaAthleteId(athleteId: Int): Completable {
        return Completable.fromAction { sharedPreferences.edit().putInt(KEY_STRAVA_ATHLETE_ID, athleteId).apply() }
    }

    override fun getStravaAthleteId(): Int? {
        val athleteId = sharedPreferences.getInt(KEY_STRAVA_ATHLETE_ID, 0)
        return if (athleteId == 0) null else athleteId
    }
}
