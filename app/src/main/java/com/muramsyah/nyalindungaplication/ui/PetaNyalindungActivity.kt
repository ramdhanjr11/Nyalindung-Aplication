package com.muramsyah.nyalindungaplication.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import com.mapbox.maps.Style
import com.muramsyah.nyalindungaplication.R
import com.muramsyah.nyalindungaplication.databinding.ActivityPetaNyalindungBinding

class PetaNyalindungActivity : AppCompatActivity(), OnMapReadyCallback {

    private var _binding : ActivityPetaNyalindungBinding? = null
    private val binding get() = _binding!!

    private lateinit var mapBoxMap: MapboxMap
    private lateinit var mapView : MapView

    private lateinit var symbolManager: SymbolManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_access_token))

        _binding = ActivityPetaNyalindungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapBoxMap = mapboxMap
        initAddMarker()

        val lating = LatLng(-7.007110305275969, 106.9287760139071)
        val position = CameraPosition.Builder().target(lating).zoom(11.0).tilt(10.0).build()
        mapBoxMap.animateCamera(CameraUpdateFactory.newCameraPosition(position))
    }

    private fun initAddMarker() {
        mapBoxMap.setStyle(Style.SATELLITE_STREETS) { style ->
            symbolManager = SymbolManager(mapView, mapBoxMap, style)
            symbolManager.iconAllowOverlap = true

            style.addImage("ICON_ID", BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default))

            val cisituLocation = LatLng(-7.062089514488456, 106.9281729415598)
            val kertaangsanaLocation = LatLng(-7.036619437188663, 106.9491565819924)
            val nyalindungLocation = LatLng(-7.0296637283284085, 106.9165509450362)
            val mekarsariLocation = LatLng(-7.016416157806347, 106.95631066931274)
            val bojongkalongLocation = LatLng(-6.998315325145765, 106.93593146563688)
            val bojongsariLocation = LatLng(-7.007122650471551, 106.91390083625475)
            val sukamajuLocation = LatLng(-7.009875283688148, 106.88204658732033)
            val cijangkarLocation = LatLng(-6.997047210593189, 106.96181073542873)
            val neglasariLocation = LatLng(-6.976427106498716, 106.96041796291922)
            val wangunrejaLocation = LatLng(-6.985551905039139, 106.89173123601519)

            initAddSymbolManager(cisituLocation, "Cisitu")
            initAddSymbolManager(kertaangsanaLocation, "Kertaangsana")
            initAddSymbolManager(nyalindungLocation, "Nyalindung")
            initAddSymbolManager(mekarsariLocation, "Mekarsari")
            initAddSymbolManager(bojongkalongLocation, "Bojongkalong")
            initAddSymbolManager(bojongsariLocation, "Bojongsari")
            initAddSymbolManager(sukamajuLocation, "Sukamaju")
            initAddSymbolManager(cijangkarLocation, "Cijangkar")
            initAddSymbolManager(neglasariLocation, "Neglasari")
            initAddSymbolManager(wangunrejaLocation, "Wangunreja")
        }

    }

    private fun initAddSymbolManager(latlng: LatLng, namaWilayah: String) {
        symbolManager.create(
            SymbolOptions()
                .withLatLng(LatLng(latlng.latitude, latlng.longitude))
                .withIconImage("ICON_ID")
                .withIconSize(1.5f)
                .withIconOffset(arrayOf(0f, -1.5f))
                .withTextField(namaWilayah)
                .withTextHaloColor("rgba(255, 255, 255, 100)")
                .withTextHaloWidth(5.0f)
                .withTextAnchor("top")
                .withTextOffset(arrayOf(0f, 1.5f))
                .withDraggable(false)
        )
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}