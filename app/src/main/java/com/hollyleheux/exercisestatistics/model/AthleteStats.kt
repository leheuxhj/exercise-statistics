package com.hollyleheux.exercisestatistics.model

data class AthleteStats(
        val yearToDateRunTotals: ActivitySetMetrics?,
        val yearToDateRideTotals: ActivitySetMetrics?,
        val yearToDateSwimTotals: ActivitySetMetrics?
) {
    data class ActivitySetMetrics(
            val activityCount: Int,
            val distanceCovered: Float,
            val movingTime: Int,
            val elapsedTime: Int,
            val elevationGain: Float,
            val achievementCount: Int
    )
}
