package com.carlos.android_practica1.activities;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class AgregarGraficas {
    private LinearLayout linearLayout;
    private Context context;
    private PieChart pieChart;
    private BarChart barChart;

    private String[] meses = new String[]{"Enero","Febrero","Marzo","Abril","Mayo"};
    private int[]sale = new int[]{25,20,38,10,15};
    private int[]colors = new int[]{Color.BLACK,Color.RED,Color.GREEN,Color.BLUE,Color.LTGRAY};

    public AgregarGraficas(){

    }

    public AgregarGraficas(LinearLayout linearLayout, Context context) {
        this.linearLayout = linearLayout;
        this.context = context;
    }

    public void agregarPie(){
        pieChart = new PieChart(context);
        pieChart.setMinimumHeight(700);
        linearLayout.addView(pieChart);
    }

    public void agregarBarra(){
        barChart = new BarChart(context);
        barChart.setMinimumHeight(700);
        linearLayout.addView(barChart);
    }

    private Chart getSameChartBarra(Chart chart,String descripcion,int textColor,int backgroudColor,int timeAnimation){
        //chart.getDescription().setText(descripcion);
        //chart.getDescription().setTextSize(25);
        chart.setBackgroundColor(backgroudColor);
        chart.animateY(timeAnimation);
        leyendaBarr(chart,descripcion);
        return chart;
    }

    private Chart getSameChartPie(Chart chart,String descripcion,int textColor,int backgroudColor,int timeAnimation){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(25);
        chart.setBackgroundColor(backgroudColor);
        chart.animateY(timeAnimation);
        leyendaPie(chart);
        return chart;
    }

    private void leyendaPie(Chart chart){
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry>entries = new ArrayList<>();

        for (int i = 0; i < meses.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor=colors[i];
            entry.label=meses[i];
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
        entry.formColor=Color.rgb(93,109,126);
        entry.label=description;
        entries.add(entry);
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry> getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++) {
            entries.add(new BarEntry(i,sale[i]));
        }
        return entries;
    }

    private ArrayList<PieEntry>getPieEntries(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++) {
            entries.add(new PieEntry(sale[i]));
        }
        return entries;
    }

    private void axisX(XAxis xaxis){
        xaxis.setGranularityEnabled(true);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setValueFormatter(new IndexAxisValueFormatter(meses));
    }

    private void axisYLeft(YAxis yaxis){
        yaxis.setSpaceTop(30);
        yaxis.setAxisMinimum(0);
    }

    private void axisYRigth(YAxis yaxis){
        yaxis.setEnabled(false);
    }

    public void createChart(){
        barChart= (BarChart) getSameChartBarra(barChart,"Series",Color.RED,Color.rgb(220, 118, 51),3000);
        barChart.setTouchEnabled(false);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisYLeft(barChart.getAxisLeft());
        axisYRigth(barChart.getAxisRight());


        pieChart=(PieChart) getSameChartPie(pieChart,"Ventas",Color.GRAY,Color.MAGENTA,3000);
        pieChart.setTouchEnabled(false);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(12);
        pieChart.setData(getPieData());
        pieChart.invalidate();
        //pieChart.setDrawHoleEnabled(false);
    }

    private DataSet getDataBarra(DataSet dataSet){
        dataSet.setColor(Color.rgb(93,109,126));
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private DataSet getDataPie(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet = (BarDataSet)getDataBarra(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.TRANSPARENT);
        BarData barData = new BarData((barDataSet));
        barData.setBarWidth(0.45f);
        return  barData;
    }

    private PieData getPieData(){
        PieDataSet pieDataSet = (PieDataSet)getDataPie(new PieDataSet(getPieEntries(),""));
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());
        return new PieData(pieDataSet);
    }

}
