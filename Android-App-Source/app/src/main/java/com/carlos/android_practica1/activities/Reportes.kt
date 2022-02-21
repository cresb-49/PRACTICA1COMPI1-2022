package com.carlos.android_practica1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.android_practica1.R

class Reportes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)
        recibirDatos()
    }

    fun recibirDatos(){
        println("debuj")
        val datos: String? = intent.extras?.get("text") as String?
        println("Datos recibidos: "+datos)

    }
}