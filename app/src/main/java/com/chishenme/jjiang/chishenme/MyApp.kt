package com.chishenme.jjiang.chishenme

import android.app.Application
import android.content.Context
import com.chishenme.jjiang.chishenme.model.Prefs

/**
 * Created by jjiang on 5/25/2018.
 */
class MyApp: Application() {

    init {
        instance = this
    }

    companion object {
        var prefs: Prefs? = null
        private var instance: MyApp? = null

        @JvmStatic fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()

    }



}