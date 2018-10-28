package com.hollyleheux.exercisestatistics.data.entities

import com.google.gson.annotations.SerializedName

data class StravaAccessTokenRequest(
        @SerializedName("client_id") val clientId: String,
        @SerializedName("code") val code: String,
        @SerializedName("client_secret") val clientSecret: String
)
