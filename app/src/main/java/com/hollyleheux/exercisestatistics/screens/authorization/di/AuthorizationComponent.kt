package com.hollyleheux.exercisestatistics.screens.authorization.di

import com.hollyleheux.exercisestatistics.di.ActivityScope
import com.hollyleheux.exercisestatistics.screens.authorization.AuthorizationActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [AuthorizationModule::class])
interface AuthorizationComponent {
    fun inject(activity: AuthorizationActivity)
}
