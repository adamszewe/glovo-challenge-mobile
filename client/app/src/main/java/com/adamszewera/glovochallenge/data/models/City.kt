package com.adamszewera.glovochallenge.data.models

import com.google.android.gms.maps.model.LatLng

data class City (
    var code: String,
    var name: String,
    var country_code: String,
    var currency: String,
    var enabled: Boolean,
    var busy: Boolean,
    var time_zone: String,
    var language_code: String,
    var working_area: List<LatLng>
) {
    // default empty constructor
    constructor(): this(
        "",
        "",
        "",
        "",
        false,
        false,
        "",
        "",
        emptyList()
    )
}