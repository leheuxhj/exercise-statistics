package com.hollyleheux.exercisestatistics.data.entities

import com.google.gson.annotations.SerializedName

data class AthleteEntity(
        @SerializedName("id") val athleteid: Int,
        @SerializedName("firstname") val firstname: String,
        @SerializedName("lastname") val lastname: String)
