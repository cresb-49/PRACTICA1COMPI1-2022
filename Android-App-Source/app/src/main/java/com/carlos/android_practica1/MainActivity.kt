package com.carlos.android_practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.carlos.android_practica1.activities.ContendersGraphics
import com.carlos.android_practica1.activities.Reportes
import com.carlos.android_practica1.backened.lexerParser.ProcesadorGraficos

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonProcesar: Button = findViewById(R.id.buttonProcesar)
        buttonProcesar.setOnClickListener { view ->

            val text : EditText? = findViewById(R.id.editTextTextMultiLine)
            if(text !=null){
                val info : String? = text.text.toString();
                if(info!=null){
                    val procesador = ProcesadorGraficos()
                    procesador.ejecutar(info)
                    val errores = procesador.reporteFinalErrores
                    println(errores.toString())

                }else{
                    println("No se puedo recuperar el texto escrito")
                }
            }else{
                println("No se pudo recuperar el cuadro de texto")
            }
        }

        /**
        val buttonReportes: Button = findViewById(R.id.buttonReportes)
        buttonReportes.setOnClickListener { view ->

            val sendIntent = Intent(this,Reportes::class.java).apply {
                putExtra("text","text")
            }
            startActivity(sendIntent)
        }**/
        val buttonReportes: Button = findViewById(R.id.buttonReportes)
        buttonReportes.setOnClickListener { view ->

            val sendIntent = Intent(this,ContendersGraphics::class.java).apply {
                putExtra("text","text")
            }
            startActivity(sendIntent)
        }
    }
}