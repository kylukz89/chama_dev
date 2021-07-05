package com.example.chama_kotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import kotlin.concurrent.thread

/**
 * App desenvolvido como defasio/teste para ingresso
 * na empresa CHAMA cadastrada no site da REVELO
 *
 * OBS: Apenas experimental e primeiro contato com KOTLIN NATIVO
 *
 * LINK: https://developers.google.com/maps/documentation/android-sdk/current-place-tutorial?hl=pt-br
 *
 * @author      Igor Maximo
 * @date        01/07/2021
 */
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    // Localização atual
    private var latitudeAtual: Double? = 0.0
    private var longitudeAtual: Double? = 0.0
    val PERMISSION_ID = 42
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        // Inicia a variável fusedLocation para rodar o serviço de geo
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_ID)
        // Thread separada para não atrapalhar a abertura completa da main activity
        thread {
            var i = 0
            // Enquanto não conseguir a atualização da localização atual, fica tentando...
            while (latitudeAtual == 0.0) {
                Thread.sleep(1000)
                System.err.println("**============> " + i)
                // Pega localização atual
                getLastLocation()
                // Conta qts tentativas de pegar localização teve para log...
                i++
            }

            latitudeAtual?.let { longitudeAtual?.let { it1 -> getCompleteAddressString(it, it1) } }
        }











        var places = PlacesMapAPI()
        places.getRetornarPlacesPorGeolocalizcao("", "")


    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = latitudeAtual?.let { longitudeAtual?.let { it1 -> LatLng(it, it1) } }
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


    private fun getCompleteAddressString(LATITUDE: Double, LONGITUDE: Double): String? {
        var strAdd = ""
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses: List<Address>? = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
            if (addresses != null) {
                val returnedAddress: Address = addresses[0]
                val strReturnedAddress = StringBuilder("")
                for (i in 0..returnedAddress.getMaxAddressLineIndex()) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n")
                }
                strAdd = strReturnedAddress.toString()
            } else {
//                Log.w("My Current loction address", "No Address returned!")
            }
        } catch (e: Exception) {
            e.printStackTrace()
//            Log.w("My Current loction address", "Canont get Address!")
        }
        return strAdd
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        latitudeAtual = location.latitude.toString().toDouble()
                        longitudeAtual = location.longitude.toDouble()
                        val voceAqui = latitudeAtual?.let {
                            longitudeAtual?.let { it1 ->
                                LatLng(
                                    it,
                                    it1
                                )
                            }
                        }
                        mMap.addMarker(MarkerOptions().position(voceAqui).title("Você aqui!"))
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(voceAqui))
                        System.err.println("**============> " + location.latitude.toString())
                        System.err.println("**============> " + location.longitude.toString())
                        val you = LatLng(location.latitude, location.longitude)
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(you, 17f))
                    }
                }
            } else {
                // Solicita que seja ligado o GPS
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }

    // -20.9051498,-51.3511061

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }


    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
            System.err.println("**============> " + mLastLocation.latitude.toString())
            System.err.println("**============> " + mLastLocation.longitude.toString())
        }
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            PERMISSION_ID
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLastLocation()
            }
        }
    }
}

