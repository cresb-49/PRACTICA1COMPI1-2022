package com.carlos.android_practica1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.carlos.android_practica1.R

class Reportes : AppCompatActivity() {

    private lateinit var tableLayout : TableLayout
    private val header = arrayOf("Lexema","Línea","Columna","Tipo","Descripción")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)
        tableLayout = findViewById(R.id.TabLinearLayout)
        recibirDatos()
    }

    fun recibirDatos(){
        println("debuj")
        val datos: String? = intent.extras?.get("text") as String?
        println("Datos recibidos: "+datos)
    }

    fun rellenarTabla(){
        val tableDynamicError = TableDynamicError(tableLayout,applicationContext)
        tableDynamicError.addHeader(header);

    }
}