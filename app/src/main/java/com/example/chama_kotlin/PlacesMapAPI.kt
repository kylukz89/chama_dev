package com.example.chama_kotlin

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class PlacesMapAPI {


    fun sendPostRequest(procura : String): StringBuffer {
//        var reqParam = URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode(procura +"+in+Andradina", "UTF-8")
//        reqParam += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("AIzaSyAoQZzw0aLm1Wk7T6wNV8Z74Yh4qfpuiB0", "UTF-8")
        val mURL = URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+procura +"+in+Andradina"+"&key=AIzaSyAoQZzw0aLm1Wk7T6wNV8Z74Yh4qfpuiB0")

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "POST"

            val wr = OutputStreamWriter(getOutputStream());
//            wr.write(reqParam);
            wr.flush();

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response : $response")

                return response
            }
        }
    }
}