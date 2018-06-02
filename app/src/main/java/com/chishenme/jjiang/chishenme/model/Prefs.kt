package com.chishenme.jjiang.chishenme.model

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by jjiang on 5/24/2018.
 */
class Prefs(context: Context) {
    val PREFS_LISTFILE = "filenames"
    val DEFAULT_FILE = "default_ file"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_LISTFILE, 0)

    var fileName : String
        get() =  prefs.getString(DEFAULT_FILE, "")
        set(value) { prefs.edit().putString(DEFAULT_FILE, value).apply()}

}