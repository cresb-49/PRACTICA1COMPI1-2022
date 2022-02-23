package com.carlos.android_practica1.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import com.carlos.android_practica1.R
import com.carlos.android_practica1.backened.lexerParser.PaqueteReportes
import com.carlos.android_practica1.backened.obj.ConvertRow

class Reportes : AppCompatActivity() {

    private lateinit var tableLayoutError : TableLayout
    private lateinit var tableLayoutGraphics : TableLayout
    private lateinit var tableLayoutOcurrencias : TableLayout
    private lateinit var labelError : TextView
    private lateinit var labelGraphics: TextView
    private lateinit var labelOcurrencia : TextView

    private val headerError = arrayOf("Lexema","Línea","Columna","Tipo","Descripción")
    private val headerGraphics = arrayOf("Operador","Línea","Columna","Ocurrencia")
    private val headerOcurrencias = arrayOf("Objeto","Cantidad de Definiciones")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)
        tableLayoutError = findViewById(R.id.tableError);
        tableLayoutGraphics = findViewById(R.id.tableGraphics);
        tableLayoutOcurrencias = findViewById(R.id.tableOcurrencias);


        labelError = findViewById(R.id.labelError)
        labelGraphics = findViewById(R.id.labelGraphics)
        labelOcurrencia =findViewById(R.id.labelOcurrencia)

        recibirDatos()
    }

    fun recibirDatos(){
        val datos: PaqueteReportes? = intent.extras?.get("reports") as PaqueteReportes?
        if(datos!=null){

            if(datos.erroresFinal.isEmpty()){
                labelError.visibility = View.INVISIBLE
                labelGraphics.visibility =View.VISIBLE
                labelOcurrencia.visibility =View.VISIBLE
                rellenarTablaGraficos(datos)
                rellenarTablaOcurrencias(datos)
            }else{
                labelError.visibility = View.VISIBLE
                labelGraphics.visibility =View.INVISIBLE
                labelOcurrencia.visibility =View.INVISIBLE
                rellenarTablaErrores(datos)
            }
            println("Se recuperaron los datos")
        }else{
            println("No se recuperaron los datos")
        }
    }

    fun rellenarTablaErrores(paqueteReportes: PaqueteReportes){
        val tableDynamicError = TableDynamicError(tableLayoutError,applicationContext)
        tableDynamicError.addHeader(headerError)
        val convertRow = ConvertRow()
        tableDynamicError.addData(paqueteReportes.erroresFinal)
        tableDynamicError.backgroundHeader(Color.rgb(10,109,125))
        tableDynamicError.backgroundData(Color.rgb(177,217,223),Color.rgb(230,245,247))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }

    fun rellenarTablaGraficos(paqueteReportes: PaqueteReportes){
        val tableDynamicError = TableDynamicError(tableLayoutGraphics,applicationContext)
        tableDynamicError.addHeader(headerOcurrencias)
        val convertRow = ConvertRow()
        tableDynamicError.addData(paqueteReportes.graficos)
        tableDynamicError.backgroundHeader(Color.rgb(118,68,138))
        tableDynamicError.backgroundData(Color.rgb(195,155,211),Color.rgb(235,222,240))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }

    fun rellenarTablaOcurrencias(paqueteReportes: PaqueteReportes){
        val tableDynamicError = TableDynamicError(tableLayoutOcurrencias,applicationContext)
        tableDynamicError.addHeader(headerGraphics)
        val convertRow = ConvertRow()
        tableDynamicError.addData(paqueteReportes.ocurrencias)
        tableDynamicError.backgroundHeader(Color.rgb(236,120,70))
        tableDynamicError.backgroundData(Color.rgb(249,164,127),Color.rgb(254,214,196))
        tableDynamicError.textColorData(Color.BLACK)
        tableDynamicError.textColorHeader(Color.BLACK)
    }
}