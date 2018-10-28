package com.hollyleheux.exercisestatistics.data.entities

import com.google.gson.annotations.SerializedName

data class StravaAccessTokenEntity(@SerializedName("access_token") val accessToken: String,
        @SerializedName("athlete") val athleteEntity: AthleteEntity)
