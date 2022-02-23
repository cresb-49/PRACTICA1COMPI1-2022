package com.carlos.android_practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.carlos.android_practica1.activities.ContendersGraphics
import com.carlos.android_practica1.activities.Reportes
import com.carlos.android_practica1.backened.lexerParser.PaqueteReportes
import com.carlos.android_practica1.backened.lexerParser.ProcesadorGraficos
import com.carlos.android_practica1.backened.obj.ErrorAnalisis
import com.carlos.android_practica1.backened.obj.Grafica

class MainActivity : AppCompatActivity() {

    private lateinit var paqueteReportes:PaqueteReportes
    private lateinit var graficas:ArrayList<Grafica>

    private lateinit var buttonProcesar: Button
    private lateinit var buttonReportes: Button
    private lateinit var buttonGraficas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonProcesar = findViewById(R.id.buttonProcesar)
        buttonReportes = findViewById(R.id.buttonReportes)
        buttonGraficas = findViewById(R.id.buttonGrafica)
        buttonGraficas.isEnabled=false

        buttonProcesar.setOnClickListener { view ->

            val text : EditText? = findViewById(R.id.editTextTextMultiLine)
            if(text !=null){
                val info : String? = text.text.toString();
                if(info!=null){
                    val procesador = ProcesadorGraficos()
                    procesador.ejecutar(info)
                    paqueteReportes = procesador.paqueteReportes
                    if(paqueteReportes.erroresFinal.isEmpty()){
                        graficas = procesador.graficasGraficar
                        buttonGraficas.isEnabled=true
                        //graficar()
                    }else{
                        buttonGraficas.isEnabled=false
                        reportes();
                    }
                }else{
                    println("No se puedo recuperar el texto escrito")
                }
            }else{
                println("No se pudo recuperar el cuadro de texto")
            }
        }

        buttonReportes.setOnClickListener { view ->
            reportes()
        }

        buttonGraficas.setOnClickListener { view ->
            graficar()
        }
    }

    fun reportes(){
        val sendIntent = Intent(this,Reportes::class.java).apply {
            putExtra("reports",paqueteReportes)
        }
        startActivity(sendIntent)
    }

    fun graficar(){
        val sendIntent = Intent(this,ContendersGraphics::class.java).apply {
            putExtra("graficas",graficas)
        }
        startActivity(sendIntent)
    }


}