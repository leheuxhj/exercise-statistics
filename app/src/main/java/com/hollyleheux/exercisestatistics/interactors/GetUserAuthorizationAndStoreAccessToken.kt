package com.hollyleheux.exercisestatistics.interactors

import com.hollyleheux.exercisestatistics.data.local.LocalDataManager
import com.hollyleheux.exercisestatistics.repositories.StravaAuthorizationRepository
import com.hollyleheux.exercisestatistics.utils.applySchedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetUserAuthorizationAndStoreAccessToken @Inject constructor(
        private val stravaAuthorizationRepository: StravaAuthorizationRepository,
        private val localDataManager: LocalDataManager) {

    companion object {
        private const val BEARER = "Bearer "
    }

    fun execute(userAuthCode: String, observer: DisposableCompletableObserver) {
        val completable = stravaAuthorizationRepository.getAccessTokenFromStrava(userAuthCode)
                .flatMapCompletable { response ->
                    val stravaAccessToken = BEARER + response.accessToken
                    val athleteId = response.athlete.id

                    localDataManager.setStravaAccessToken(stravaAccessToken)
                            .mergeWith(localDataManager.setStravaAthleteId(athleteId))
                }

        completable.applySchedulers().subscribe(observer)
    }
}
