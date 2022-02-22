package com.carlos.android_practica1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.android_practica1.R

import android.widget.LinearLayout
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import java.util.*

class ContendersGraphics : AppCompatActivity() {

    lateinit var layout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor_graficas)
        layout = findViewById(R.id.LinearLayout)

    }
}