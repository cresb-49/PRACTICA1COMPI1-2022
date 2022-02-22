package com.carlos.android_practica1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.carlos.android_practica1.R
import com.carlos.android_practica1.backened.obj.ConvertRow

class Reportes : AppCompatActivity() {

    private lateinit var tableLayout : TableLayout
    private val header = arrayOf("Lexema","Línea","Columna","Tipo","Descripción")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)
        tableLayout = findViewById(R.id.tableError);
        recibirDatos()
        rellenarTabla();
    }

    fun recibirDatos(){
        println("debuj")
        val datos: String? = intent.extras?.get("text") as String?
        println("Datos recibidos: "+datos)
    }

    fun rellenarTabla(){
        val tableDynamicError = TableDynamicError(tableLayout,applicationContext)
        tableDynamicError.addHeader(header)
        val convertRow = ConvertRow()
        tableDynamicError.addData(convertRow.ejemplo())
    }
}