package com.example.chama_kotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList
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

    @RequiresApi(Build.VERSION_CODES.N)
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
            while (latitudeAtual == 0.0 && i < 3) {
                Thread.sleep(1000)
                System.err.println("**============> " + i)
                // Pega localização atual
                getLastLocation()
                // Conta qts tentativas de pegar localização teve para log...
                i++
            }

            latitudeAtual?.let { longitudeAtual?.let { it1 -> getCompleteAddressString(it, it1) } }
        }


        // Coleta os pontos referente empresas de gás/água
        thread {
            getVendaGasProximos("gas")
        }
    }


    fun getVendaGasProximos(gas: String) {
        var listaPontoNome = ArrayList<String>()
        var listaPontoEndereco = ArrayList<String>()
        var listaPontoGeoLat = ArrayList<String>()
        var listaPontoGeoLng = ArrayList<String>()
        var listaPontoIcone = ArrayList<String>()


        var places = PlacesMapAPI()
        var response = places.sendPostRequest(gas)

        val json = response.toString()
        val obj = JSONObject(json)
        val getArray = obj.getJSONArray("results")


        for (i in 0 until getArray.length()) {
            val objects: JSONObject
            objects = getArray.getJSONObject(i)
            // Nome do ponto
            val pontoNome = objects["name"].toString()
            // Endereço do ponto
            val pontoEndereco = objects["formatted_address"].toString()
            // Geo do ponto
            val getArrayGeo = JSONObject(objects["geometry"].toString()).getString("location")
            val json1 = getArrayGeo.toString()
            val obj1 = JSONObject(json1)
            val lat = obj1.getString("lat")
            val lng = obj1.getString("lng")
            // Ícone do ponto
            val pontoIcone = objects["icon"].toString()
            listaPontoNome.add(i, pontoNome)
            listaPontoEndereco.add(i, pontoEndereco)
            listaPontoGeoLat.add(i, lat)
            listaPontoGeoLng.add(i, lng)
            listaPontoIcone.add(i, pontoIcone)
        }

        println(listaPontoNome.get(2).toString()+"=========1> " + listaPontoNome.size)
        for (i in 0 until listaPontoGeoLat.size) {
            val latLng = LatLng(
                listaPontoGeoLat.get(i).toString().toDouble(),
                listaPontoGeoLng.get(i).toDouble()
            )

            runOnUiThread {
                MapsInitializer.initialize(this)
                mMap.addMarker(
                    MarkerOptions().position(latLng).title(listaPontoNome.get(i).toString())
//                        .icon(getBitmapFromURL(listaPontoIcone.get(i)))
                )
            }
        }
        println("=========2> " + listaPontoNome.size)


    }

/*
    fun getBitmapFromURL(src: String?): BitmapDescriptor? {
        return try {
            val url = URL(src)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input: InputStream = connection.getInputStream()
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            // Log exception
            null
        }
    }
*/
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


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//        val eu = latitudeAtual?.let { longitudeAtual?.let { it1 -> LatLng(it, it1) } }
//        mMap.addMarker(MarkerOptions().position(eu).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(eu))
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

