package com.hollyleheux.exercisestatistics.utils

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Completable.applySchedulers(): Completable {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
