package com.adamszewera.glovochallenge.data

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.adamszewera.glovochallenge.di.qualifiers.ApplicationContext
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackingRepository @Inject constructor(@ApplicationContext val context: Context) {


    private var locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    private var publisher: PublishSubject<Location> = PublishSubject.create()


    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (location != null && publisher.hasObservers()) {
                publisher.onNext(location)
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) { }

        override fun onProviderEnabled(provider: String?) { }

        override fun onProviderDisabled(provider: String?) {
            publisher.onError(Throwable(provider))
        }
    }


    @SuppressLint("MissingPermission")
    fun initTracking() {
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 100f, locationListener)
    }


    fun getLocations(): PublishSubject<Location> {
        return publisher
    }






}