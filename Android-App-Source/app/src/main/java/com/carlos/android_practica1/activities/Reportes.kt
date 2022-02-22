package com.carlos.android_practica1.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.carlos.android_practica1.R
import com.carlos.android_practica1.backened.obj.ConvertRow

class Reportes : AppCompatActivity() {

    private lateinit var tableLayoutError : TableLayout
    private lateinit var tableLayoutGraphics : TableLayout
    private lateinit var tableLayoutOcurrencias : TableLayout
    private val headerError = arrayOf("Lexema","Línea","Columna","Tipo","Descripción")
    private val headerGraphics = arrayOf("Operador","Línea","Columna","Ejemplo de Ocurrencia")
    private val headerOcurrencias = arrayOf("Objeto","Cantidad de Definiciones")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)
        tableLayoutError = findViewById(R.id.tableError);
        tableLayoutGraphics = findViewById(R.id.tableGraphics);
        tableLayoutOcurrencias = findViewById(R.id.tableOcurrencias);
        recibirDatos()
        rellenarTablaErrores()
        rellenarTablaGraficos()
        rellenarTablaOcurrencias()
    }

    fun recibirDatos(){
        println("debuj")
        val datos: String? = intent.extras?.get("text") as String?
        println("Datos recibidos: "+datos)
    }

    fun rellenarTablaErrores(){
        val tableDynamicError = TableDynamicError(tableLayoutError,applicationContext)
        tableDynamicError.addHeader(headerError)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo1())
        tableDynamicError.backgroundHeader(Color.rgb(10,109,125))
        tableDynamicError.backgroundData(Color.rgb(177,217,223),Color.rgb(230,245,247))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }

    fun rellenarTablaGraficos(){
        val tableDynamicError = TableDynamicError(tableLayoutGraphics,applicationContext)
        tableDynamicError.addHeader(headerGraphics)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo2())
        tableDynamicError.backgroundHeader(Color.rgb(118,68,138))
        tableDynamicError.backgroundData(Color.rgb(195,155,211),Color.rgb(235,222,240))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }

    fun rellenarTablaOcurrencias(){
        val tableDynamicError = TableDynamicError(tableLayoutOcurrencias,applicationContext)
        tableDynamicError.addHeader(headerOcurrencias)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo3())
        tableDynamicError.backgroundHeader(Color.rgb(236,120,70))
        tableDynamicError.backgroundData(Color.rgb(249,164,127),Color.rgb(254,214,196))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }
}