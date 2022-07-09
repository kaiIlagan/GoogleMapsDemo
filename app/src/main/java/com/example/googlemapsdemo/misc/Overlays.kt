package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

class Overlays {

    private val marquette = LatLng(46.55770982379835, -87.4095826676534)
    private val marquetteBounds = LatLngBounds(
        LatLng(46.52435129443729, -87.46710639394033),
        LatLng(46.595765259469424, -87.36647037520287)
    )

    fun addGroundOverlay(map: GoogleMap): GroundOverlay? {
        return map.addGroundOverlay(
            GroundOverlayOptions().apply {
                positionFromBounds(marquetteBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.android))
            }
        )
    }

    fun addGroundOverlayWithTag(map: GoogleMap): GroundOverlay? {
        val groundOverlay = map.addGroundOverlay(
            GroundOverlayOptions().apply {
                positionFromBounds(marquetteBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.android))
            }
        )
        groundOverlay.tag = "My Tag"
        return groundOverlay
    }
}