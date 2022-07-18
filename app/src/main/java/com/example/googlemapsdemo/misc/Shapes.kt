package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay

class Shapes {
    /*
    suspend fun addPolyline(map: GoogleMap){
        val polyline = map.addPolyline(
            PolylineOptions().apply {
                add()
                width(5f)
                color(Color.GREEN)
                geodesic(true)
            }
        )

        delay(5000L)

        val newList = listOf()

        polyline.points = newList
    }

    */

    fun addPolygon(map: GoogleMap){
        val polygon = map.addPolygon(
            PolygonOptions().apply {

            }
        )
    }

    /*
    suspend fun addCircle(map: GoogleMap){
        val circle = map.addCircle(
            CircleOptions().apply {
                center()
                radius(50000.0)
                fillColor(R.color.purple_500)
                strokeColor(R.color.purple_500)
            }
        )
    }*/
}