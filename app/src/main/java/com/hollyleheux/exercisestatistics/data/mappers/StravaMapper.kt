package com.hollyleheux.exercisestatistics.data.mappers

import com.hollyleheux.exercisestatistics.data.entities.AthleteEntity
import com.hollyleheux.exercisestatistics.data.entities.StravaAccessTokenEntity
import com.hollyleheux.exercisestatistics.model.Athlete
import com.hollyleheux.exercisestatistics.model.StravaAccessToken
import javax.inject.Inject

class StravaMapper @Inject constructor() {

    fun map(athleteEntity: AthleteEntity): Athlete {
        return Athlete(athleteEntity.athleteid, athleteEntity.firstname, athleteEntity.lastname)
    }

    fun map(stravaAccessTokenEntity: StravaAccessTokenEntity): StravaAccessToken{
        return StravaAccessToken(stravaAccessTokenEntity.accessToken, map(stravaAccessTokenEntity.athleteEntity))
    }
}
