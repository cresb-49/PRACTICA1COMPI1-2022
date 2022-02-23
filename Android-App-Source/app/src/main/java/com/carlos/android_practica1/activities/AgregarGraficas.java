package com.carlos.android_practica1.activities;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import com.carlos.android_practica1.backened.obj.Grafica;
import com.carlos.android_practica1.backened.obj.GraficaBarra;
import com.carlos.android_practica1.backened.obj.GraficaPie;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.Random;

public class AgregarGraficas {
    private LinearLayout linearLayout;
    private Context context;

    public AgregarGraficas(){

    }

    public AgregarGraficas(LinearLayout linearLayout, Context context) {
        this.linearLayout = linearLayout;
        this.context = context;
    }

    private Chart getSameChartBarra(Chart chart,String descripcion,int textColor,int backgroudColor,int timeAnimation){
        chart.getDescription().setText("");
        chart.getDescription().setTextSize(25);
        chart.setBackgroundColor(backgroudColor);
        chart.animateY(timeAnimation);
        leyendaBarr(chart,descripcion);
        return chart;
    }

    private Chart getSameChartPie(Chart chart,String descripcion,int textColor,int backgroudColor,int timeAnimation,int[]colors,String[]etiquetas){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(25);
        chart.setBackgroundColor(backgroudColor);
        chart.animateY(timeAnimation);
        leyendaPie(chart,colors,etiquetas);
        return chart;
    }

    private void leyendaPie(Chart chart,int[]colors,String[]etiquetas){
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry>entries = new ArrayList<>();

        for (int i = 0; i < etiquetas.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor=colors[i];
            entry.label=etiquetas[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }
    private void leyendaBarr(Chart chart,String description){
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setTextSize(25);
        ArrayList<LegendEntry>entries = new ArrayList<>();
        LegendEntry entry = new LegendEntry();
        entry.label=description;
        entries.add(entry);
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry> getBarEntries(Double[]ejey){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < ejey.length; i++) {
            entries.add(new BarEntry(i,ejey[i].floatValue()));
        }
        return entries;
    }

    private ArrayList<PieEntry>getPieEntries(Double[]values){

        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            entries.add(new PieEntry(values[i].floatValue()));
        }
        return entries;
    }

    private void axisX(XAxis xaxis,String[]ejex){
        xaxis.setGranularityEnabled(true);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setValueFormatter(new IndexAxisValueFormatter(ejex));
    }

    private void axisYLeft(YAxis yaxis){
        yaxis.setSpaceTop(30);
        yaxis.setAxisMinimum(0);
    }

    private void axisYRigth(YAxis yaxis){
        yaxis.setEnabled(false);
    }

    private void createBarChart(GraficaBarra graficaBarra){
        BarChart barChart = new BarChart(context);
        barChart.setMinimumHeight(700);
        linearLayout.addView(barChart);
        /**
         * Personalizacion de la grafica
         */
        barChart= (BarChart) getSameChartBarra(barChart,graficaBarra.getTitulo(),Color.TRANSPARENT,randomColor(),3000);
        barChart.setTouchEnabled(false);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData(graficaBarra.getVal()));
        barChart.invalidate();
        axisX(barChart.getXAxis(),graficaBarra.getTag());
        axisYLeft(barChart.getAxisLeft());
        axisYRigth(barChart.getAxisRight());

    }

    public void graficar(Grafica grafica){
        if(grafica instanceof GraficaBarra){
            System.out.println("Grafica de Barra");
            createBarChart((GraficaBarra) grafica);
        }
        if(grafica instanceof  GraficaPie){
            System.out.println("Grafica de Pie");
        }
    }

    private void createPieChart(GraficaPie graficaPie){
        PieChart pieChart = new PieChart(context);
        pieChart.setMinimumHeight(700);
        linearLayout.addView(pieChart);
        /** Generacion de los colores de la grafica **/
        int[] colors = new int[graficaPie.getTag().length];
        for (int i = 0; i < colors.length; i++) {
            colors[i]=randomColor();
        }
        /** Personalizacion de la grafica **/
        pieChart=(PieChart) getSameChartPie(pieChart,graficaPie.getTitulo(),Color.GRAY,randomColor(),3000,colors,graficaPie.getTag());
        pieChart.setTouchEnabled(false);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(12);
        pieChart.setData(getPieData(graficaPie.getVal(),colors));
        pieChart.invalidate();
        //pieChart.setDrawHoleEnabled(false);
    }

    private DataSet getDataBarra(DataSet dataSet){
        //dataSet.setColor(Color.rgb(93,109,126));
        dataSet.setColor(randomColor());
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private DataSet getDataPie(DataSet dataSet,int[]colors){
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }

    private BarData getBarData(Double[]ejey){
        BarDataSet barDataSet = (BarDataSet)getDataBarra(new BarDataSet(getBarEntries(ejey),""));
        barDataSet.setBarShadowColor(Color.TRANSPARENT);
        BarData barData = new BarData((barDataSet));
        barData.setBarWidth(0.45f);
        return  barData;
    }

    private PieData getPieData(Double[]values,int[]colors){
        PieDataSet pieDataSet = (PieDataSet)getDataPie(new PieDataSet(getPieEntries(values),""),colors);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());
        return new PieData(pieDataSet);
    }
    private int randomColor(){
        Random rnd = new Random();
        int min = 68;
        int max = 205;
        int color = Color.argb(255, rnd.nextInt(max + min) + min, rnd.nextInt(max + min) + min, rnd.nextInt(max + min) + min);
        return color;
    }

}
