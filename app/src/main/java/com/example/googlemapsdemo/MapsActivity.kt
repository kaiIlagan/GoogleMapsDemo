package com.example.googlemapsdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.googlemapsdemo.databinding.ActivityMapsBinding
import com.example.googlemapsdemo.misc.CameraAndViewport
import com.example.googlemapsdemo.misc.TypeAndStyle
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val sydney = LatLng(-34.0, 151.0)
    private val marquette = LatLng(46.55770982379835, -87.4095826676534)

    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, map)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))

        val marquetteMarker = map.addMarker(MarkerOptions()
            .position(marquette)
            .title("Marker in Marquette")
            .snippet("Home to Northern Michigan University")
            .draggable(true)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        marquetteMarker.tag = "College Town"
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(marquette, 10f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(map, this)

        addPolyline()
        /*
        lifecycleScope.launch {
            delay(4000L)
        }
        */


    }

    private fun addPolyline(){
        val polyline = map.addPolyline(
            PolylineOptions().apply {
                add(sydney, marquette)
                width(5f)
                color(Color.GREEN)
            }
        )
    }

}