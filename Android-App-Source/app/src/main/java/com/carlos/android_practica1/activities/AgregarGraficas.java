package com.carlos.android_practica1.activities;

import android.content.Context;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;

public class AgregarGraficas {
    private LinearLayout linearLayout;
    private Context context;


    public AgregarGraficas(){

    }

    public AgregarGraficas(LinearLayout linearLayout, Context context) {
        this.linearLayout = linearLayout;
        this.context = context;
    }

    public void agregar(){
        PieChart pieChart = new PieChart(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        pieChart.setLayoutParams(layoutParams);
        this.linearLayout.addView(pieChart);
    }
}
