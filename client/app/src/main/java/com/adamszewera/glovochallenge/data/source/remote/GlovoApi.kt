package com.adamszewera.glovochallenge.data.source.remote

import com.adamszewera.glovochallenge.data.models.City
import com.adamszewera.glovochallenge.data.models.Country
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit 2 api interface
 */
interface GlovoApi {


    @GET("countries")
    fun getCountries(): Observable<List<Country>>

    @GET("cities")
    fun getCities(): Observable<List<City>>

    @GET("cities/{city_code}")
    fun getCity(@Path("city_code") cityCode: String): Observable<City>


}