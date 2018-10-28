package com.hollyleheux.exercisestatistics.screens.authorization.di

import com.hollyleheux.exercisestatistics.di.ActivityScope
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationActivity
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationContract
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationPresenter
import dagger.Module
import dagger.Provides

@Module
class AuthorizationModule(val activity: AuthorizationActivity) {

    @Provides
    @ActivityScope
    fun provideAuthorizationView(): AuthorizationContract.View = activity

    @Provides
    @ActivityScope
    fun provideAuthorizationPresenter(view: AuthorizationContract.View) = AuthorizationPresenter(view)
}
