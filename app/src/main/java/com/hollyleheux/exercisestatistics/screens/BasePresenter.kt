package com.hollyleheux.exercisestatistics.screens

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V> : BasePresenterInterface<V> {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun <D : Disposable> D.addToCompositeDisposable(): D {
        compositeDisposable.add(this)
        return this
    }
}
