package com.adamszewera.glovochallenge.data.source.remote

import com.adamszewera.glovochallenge.data.models.City
import com.adamszewera.glovochallenge.data.models.Country
import io.reactivex.Observable

interface GlovoDataSource {


    fun getCountries(): Observable<List<Country>>

    fun getCities(): Observable<List<City>>

    fun getCity(cityCode: String): Observable<City>


}