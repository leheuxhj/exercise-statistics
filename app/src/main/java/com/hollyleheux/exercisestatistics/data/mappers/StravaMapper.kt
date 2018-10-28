package com.hollyleheux.exercisestatistics.data.mappers

import com.hollyleheux.exercisestatistics.data.entities.AthleteEntity
import com.hollyleheux.exercisestatistics.data.entities.AthleteStatsEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenEntity
import com.hollyleheux.exercisestatistics.model.Athlete
import com.hollyleheux.exercisestatistics.model.AthleteStats
import com.hollyleheux.exercisestatistics.model.StravaAccessToken
import javax.inject.Inject

class StravaMapper @Inject constructor() {

    fun map(athleteEntity: AthleteEntity): Athlete {
        return Athlete(athleteEntity.athleteid, athleteEntity.firstname, athleteEntity.lastname)
    }

    fun map(stravaAccessTokenEntity: StravaAccessTokenEntity): StravaAccessToken{
        return StravaAccessToken(stravaAccessTokenEntity.accessToken, map(stravaAccessTokenEntity.athleteEntity))
    }

    fun map(athleteStatsEntity: AthleteStatsEntity): AthleteStats {
        return AthleteStats(map(athleteStatsEntity.yearToDateRunTotals),
                map(athleteStatsEntity.yearToDateRideTotals),
                map(athleteStatsEntity.yearToDateSwimTotals))
    }

    private fun map(activitySetMetricsEntity: AthleteStatsEntity.ActivitySetMetrics?): AthleteStats.ActivitySetMetrics? {
        return activitySetMetricsEntity?.let { AthleteStats.ActivitySetMetrics(it.activityCount,
                it.distanceCovered,
                it.movingTime,
                it.elapsedTime,
                it.elevationGain,
                it.achievementCount) }
    }
}
