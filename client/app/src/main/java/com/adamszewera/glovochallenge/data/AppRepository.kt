package com.adamszewera.glovochallenge.data

import com.adamszewera.glovochallenge.data.source.local.PreferencesDataSource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val prefsDataSource: PreferencesDataSource) {


    fun isFirstAccess(): Observable<Boolean> {
        return Observable.just(prefsDataSource.getFirstAccess())
    }

    fun setFirstAccess(firstAccess: Boolean): Observable<Boolean> {
        return Observable.just(prefsDataSource.setFirstAccess(firstAccess))
    }

}