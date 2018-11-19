package com.adamszewera.glovochallenge.data.source.remote

import com.adamszewera.glovochallenge.data.models.City
import com.adamszewera.glovochallenge.data.models.Country
import io.reactivex.Observable

class GlovoRetrofitDataSource constructor(private val api: GlovoApi): GlovoDataSource {


    override fun getCountries(): Observable<List<Country>> {
        return api.getCountries()
    }

    override fun getCities(): Observable<List<City>> {
        return api.getCities()
    }

    override fun getCity(cityCode: String): Observable<City> {
        return api.getCity(cityCode)
    }
}