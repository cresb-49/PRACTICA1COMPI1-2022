package com.carlos.android_practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.carlos.android_practica1.activities.Reportes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonProcesar: Button = findViewById(R.id.buttonProcesar)
        buttonProcesar.setOnClickListener { view ->
            println("Precione el boton procesar")
        }

        val buttonReportes: Button = findViewById(R.id.buttonReportes)
        buttonReportes.setOnClickListener { view ->

            val sendIntent = Intent(this,Reportes::class.java).apply {
                putExtra("text","text")
            }
            startActivity(sendIntent)
            /**if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }*/
        }


    }
}