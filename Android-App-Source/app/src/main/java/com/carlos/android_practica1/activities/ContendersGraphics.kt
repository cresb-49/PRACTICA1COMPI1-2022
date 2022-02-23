package com.carlos.android_practica1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.carlos.android_practica1.R

import android.widget.LinearLayout
import com.carlos.android_practica1.backened.lexerParser.PaqueteReportes
import com.carlos.android_practica1.backened.obj.Grafica
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import java.util.*
import kotlin.collections.ArrayList

class ContendersGraphics : AppCompatActivity() {

    lateinit var layout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor_graficas)
        layout = findViewById(R.id.LinearLayout)
        recibirDatos()
        //graficar()
    }

    fun recibirDatos(){
        val datos: ArrayList<Grafica>? = intent.extras?.get("graficas") as ArrayList<Grafica>?
        if(datos!=null){
            println("Se recuperaron los datos")
        }else{
            println("No se recuperaron los datos")
        }
    }

    fun graficar(){
        val agregarGraficas = AgregarGraficas(layout,applicationContext)
    }
}