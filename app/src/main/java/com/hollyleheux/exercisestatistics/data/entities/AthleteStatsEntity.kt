package com.hollyleheux.exercisestatistics.data.entities

import com.google.gson.annotations.SerializedName

data class AthleteStatsEntity(
        @SerializedName("ytd_run_totals") val yearToDateRunTotals: ActivitySetMetrics?,
        @SerializedName("ytd_ride_totals") val yearToDateRideTotals: ActivitySetMetrics?,
        @SerializedName("ytd_swim_totals") val yearToDateSwimTotals: ActivitySetMetrics?
){
    data class ActivitySetMetrics(
            @SerializedName("count") val activityCount: Int,
            @SerializedName("distance") val distanceCovered: Float,
            @SerializedName("moving_time") val movingTime: Int,
            @SerializedName("elapsed_time") val elapsedTime: Int,
            @SerializedName("elevation_gain") val elevationGain: Float,
            @SerializedName("achievement_count") val achievementCount: Int
    )
}
