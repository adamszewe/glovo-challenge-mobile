package com.adamszewera.glovochallenge.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesDataSource @Inject constructor(private val prefs: SharedPreferences) {

    private val KEY_FIRST_ACCESS = "key_first_access"

    fun getFirstAccess(): Boolean {
        return prefs.getBoolean(KEY_FIRST_ACCESS, true)
    }

    fun setFirstAccess(firstAccess: Boolean): Boolean {
        return setBoolean(KEY_FIRST_ACCESS, firstAccess)
    }



    /*
     * Private helper methods
     */
    private fun setBoolean(key: String, value: Boolean): Boolean {
        return prefs.edit()
            .putBoolean(key, value)
            .commit()
    }

}