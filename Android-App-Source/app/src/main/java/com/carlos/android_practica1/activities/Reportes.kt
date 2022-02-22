package com.carlos.android_practica1.activities

import android.content.Intent
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
    }

    fun rellenarTablaGraficos(){
        val tableDynamicError = TableDynamicError(tableLayoutGraphics,applicationContext)
        tableDynamicError.addHeader(headerGraphics)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo2())
    }

    fun rellenarTablaOcurrencias(){
        val tableDynamicError = TableDynamicError(tableLayoutOcurrencias,applicationContext)
        tableDynamicError.addHeader(headerOcurrencias)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo3())
    }
}