package com.cubaback.unete.cache

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

/**
 * General Preferences Helper class, used for storing preference values using the Preference API
 */

open class PreferencesHelper(context: Context) {

    companion object {
        private val PREF_BUFFER_PACKAGE_NAME = "com.cubaback.unete.cache.preferences"

        private val PREF_KEY_LAST_CACHE_BUSSINESSES = "last_cache_bussinesses"
        private val PREF_KEY_LAST_CACHE_ADVERTISEMENTS = "last_cache_advertisements"
        private val PREF_KEY_LAST_CACHE_CATEGORIES = "last_cache_categories"

        private val PREF_KEY_TOKEN = "token"
    }

    private val unetePref: SharedPreferences

    init {
        unetePref = context.getSharedPreferences(PREF_BUFFER_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */

    var token : String
        get() = unetePref.getString(PREF_KEY_TOKEN, "")
        set(strToken) = unetePref.edit().putString(PREF_KEY_TOKEN, strToken) .apply()

    var lastCacheBusinesses : Long
        get() = unetePref.getLong(PREF_KEY_LAST_CACHE_BUSSINESSES, 0)
        set(value) = unetePref.edit().putLong(PREF_KEY_LAST_CACHE_BUSSINESSES, value).apply()

    var lastCacheAdvertisement : Long
        get() = unetePref.getLong(PREF_KEY_LAST_CACHE_ADVERTISEMENTS, 0)
        set(value) = unetePref.edit().putLong(PREF_KEY_LAST_CACHE_ADVERTISEMENTS, value).apply()

    var lastCacheCategories : Long
        get() = unetePref.getLong(PREF_KEY_LAST_CACHE_CATEGORIES, 0)
        set(value) = unetePref.edit().putLong(PREF_KEY_LAST_CACHE_CATEGORIES, value).apply()
}
