package com.carlos.android_practica1.activities;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TableDynamicError {

    private TableLayout tableLayout;
    private Context context;
    private ArrayList<String[]>data;
    private String[]header;
    private TableRow tableRow;
    private TextView txtCell;
    private int primercolor,segundocolor;

    private boolean multicolor =false;
    private int indexC;
    private int indexR;


    public TableDynamicError(TableLayout tableLayout,Context context){
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void addHeader(String[]header){
        this.header = header;
        createHeader();
    }

    public void addData(ArrayList<String[]>data){
        this.data =data;
        createDataTable();
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        txtCell = new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(17);
    }

    private void createHeader(){
        indexC = 0;
        newRow();
        while (indexC<header.length){
            newCell();
            txtCell.setText(header[indexC++]);
            tableRow.addView(txtCell,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    private void createDataTable(){
        String info;
        for(indexR=1;indexR<=data.size();indexR++){
            newRow();
            for(indexC=0;indexC<header.length;indexC++){
                newCell();
                String[] colums = data.get(indexR-1);
                info = (indexC<colums.length)?colums[indexC]:"";
                txtCell.setText(info);
                tableRow.addView(txtCell,newTableRowParams());
            }
            tableLayout.addView(tableRow,newTableRowParams());
        }
    }

    public void backgroundHeader(int color){
        indexC = 0;
        while (indexC<header.length){
            txtCell=getCell(0,indexC++);
            txtCell.setBackgroundColor(color);
        }
    }

    public void lineColor(int color){
        indexR =0;
        while(indexR<data.size()){
            getRow(indexR++).setBackgroundColor(color);
        }
    }

    public void textColorData(int color){
        for(indexR=1;indexR<=data.size();indexR++){
            for(indexC=0;indexC<header.length;indexC++){
                getCell(indexR,indexC).setTextColor(color);
            }
        }
    }

    public void textColorHeader(int color){
        indexC=0;
        while (indexC<header.length){
            getCell(0,indexC++).setTextColor(color);
        }
    }

    public void backgroundData(int primercolor,int segundocolor){
        for(indexR=1;indexR<=data.size();indexR++){
            multicolor=!multicolor;
            for(indexC=0;indexC<header.length;indexC++){
                txtCell=getCell(indexR,indexC);
                txtCell.setBackgroundColor((multicolor)?primercolor:segundocolor);
            }
        }
        this.primercolor =primercolor;
        this.segundocolor =segundocolor;
    }


    private TableRow getRow(int index){
        return (TableRow) tableLayout.getChildAt(index);
    }

    private TextView getCell(int rowIndex,int columnIndex){
        tableRow = getRow(rowIndex);
        return (TextView) tableRow.getChildAt(columnIndex);
    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(5,1,5,1);
        params.weight=1;
        return params;
    }

}
