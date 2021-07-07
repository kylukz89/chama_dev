package com.example.chama_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


/**
 * Classe responsável por consumir APIs do Google com retorno JSON

 * @author      Igor Maximo
 * @date        07/07/2021
 */
class PlacesMapAPI {


    /**
     * Retorna da API do google places os pontos pertinentes com base na
     * procura desejada, no contexto atuao, empresas de distribuição de gás
     *
     * @author      Igor Maximo
     * @date        07/07/2021
     */
    fun sendPostRequest(procura : String): StringBuffer {
        val mURL = URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+procura +"+in+Andradina"+"&key=AIzaSyAoQZzw0aLm1Wk7T6wNV8Z74Yh4qfpuiB0")

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "POST"

            val wr = OutputStreamWriter(getOutputStream());
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