package com.chishenme.jjiang.chishenme

import android.app.Application

/**
 * Created by jjiang on 5/25/2018.
 */
class MyApp: Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}