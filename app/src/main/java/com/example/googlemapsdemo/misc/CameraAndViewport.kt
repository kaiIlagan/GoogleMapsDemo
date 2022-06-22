package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport {
    val marquette: CameraPosition = CameraPosition.Builder()
        .target(LatLng(46.55770982379835, -87.4095826676534))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()
}