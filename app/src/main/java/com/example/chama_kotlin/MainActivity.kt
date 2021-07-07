package com.example.chama_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread


/**
 * App desenvolvido como defasio/teste para ingresso
 * na empresa CHAMA cadastrada no site da REVELO
 *
 * OBS: Apenas experimental e primeiro contato com KOTLIN NATIVO
 *
 * @author      Igor Maximo
 * @date        01/07/2021
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            // Remove toolbar
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
            System.err.println(e)
        }
        setContentView(R.layout.activity_main)
        // Thread separada para não atrapalhar a abertura completa da main activity
        thread {
            // Aguarda um pouco antes de transitar a tela
            Thread.sleep(5000)
            // Inicia a tela do mapa
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}