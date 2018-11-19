package com.adamszewera.glovochallenge.data

import com.adamszewera.glovochallenge.data.models.City
import com.adamszewera.glovochallenge.data.models.Country
import com.adamszewera.glovochallenge.data.source.remote.GlovoDataSource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Here the calls are pretty simple, just GET calls to the api, so these functions may look repetitive,
 * but in case
 *
 */
@Singleton
class GlovoRepository @Inject constructor(private val glovoDataSource: GlovoDataSource) {

    fun getCountries(): Observable<List<Country>> {
        return glovoDataSource.getCountries()
    }

    fun getCities(): Observable<List<City>> {
        return glovoDataSource.getCities()
    }

    fun getCity(cityCode: String): Observable<City> {
        return glovoDataSource.getCity(cityCode)
    }

}