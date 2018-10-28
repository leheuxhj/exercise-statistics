package com.hollyleheux.exercisestatistics.screens

interface BasePresenterInterface<out V> {

    val view: V

    fun onCreate()
    fun onDestroy()
}
