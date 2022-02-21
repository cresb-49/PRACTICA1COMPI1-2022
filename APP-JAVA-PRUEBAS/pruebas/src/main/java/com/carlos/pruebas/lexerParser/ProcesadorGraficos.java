package com.carlos.pruebas.lexerParser;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import com.carlos.pruebas.ED.Pila;
import com.carlos.pruebas.obj.ErrorAnalisis;

public class ProcesadorGraficos {
    
    private Pila<ErrorAnalisis> errores;
    private ArrayList<String> reporteFinalErrores;
    private Lexer lexer;
    private ParserGraphics parserGraphics;
    private int contUnir = -1;
    

    private static final String ERROR_TYPE_LEX = "Léxico";

    public ProcesadorGraficos(){
    }

    public void ejecutar(String texto){
        reporteFinalErrores = null;
        Reader reader = new StringReader(texto);
        errores = new Pila<>();
        lexer = new Lexer(reader);
        lexer.setErrors(errores);
        parserGraphics = new ParserGraphics(lexer);
        try {
            parserGraphics.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!this.errores.isEmpty()){
            this.ajusteDeErrores();
        }else{
            this.reporteFinalErrores = new ArrayList<>();
        }
        
    }
    private void ajusteDeErrores() {
        Pila<ErrorAnalisis> pila = new Pila<>();
        ErrorAnalisis temp = null;
        for (ErrorAnalisis errorAnalisis : errores.toArrayList()) {
            if(errorAnalisis.getTipo().equals(ERROR_TYPE_LEX)){
                if(temp == null){
                    temp = errorAnalisis;
                }else{
                    if(!this.unirError(temp,errorAnalisis)){
                        pila.push(temp);
                        pila.push(errorAnalisis);
                        temp =null;
                        contUnir=-1;
                    }
                }
            }else{
                if(temp!=null){
                    pila.push(temp);
                    temp=null;
                    contUnir=-1;
                }
                pila.push(errorAnalisis);
            }
        }
        if(temp!=null){
            pila.push(temp);
            temp=null;
            contUnir =-1;
        }
        this.presentacionFinal(pila);
        temp = null;
        contUnir=-1;
    }

    private void presentacionFinal(Pila<ErrorAnalisis> pila) {
        if(pila.isEmpty()){
            this.reporteFinalErrores = new ArrayList<>();
        }else{
            this.reporteFinalErrores = new ArrayList<>();
            ArrayList<ErrorAnalisis> temp = pila.toArrayList();
            for (ErrorAnalisis errores : temp) {
                if(errores.getTipo().equals(ERROR_TYPE_LEX)){
                    String tmp = "";
                    int ref = errores.getLexema().length();
                    if(ref >1){
                        StringBuilder reversa = new StringBuilder(errores.getLexema());
                        tmp = "Error Lexico: "+reversa.reverse().toString()+" "+errores.getDescipcion()+"\nLinea: "+errores.getLinea()+", Columna: "+(errores.getColumna()-ref+1);
                    }else{
                        tmp = "Error Lexico: "+errores.getLexema()+" "+errores.getDescipcion()+"\nLinea: "+errores.getLinea()+", Columna: "+errores.getColumna();
                    }
                    
                    this.reporteFinalErrores.add(tmp);
                }else{
                    this.reporteFinalErrores.add(errores.getDescipcion());
                }
            }
        }
    }

    private boolean unirError(ErrorAnalisis temp, ErrorAnalisis errorAnalisis) {
        if(temp.getLinea() == errorAnalisis.getLinea()){
            if((temp.getColumna()+contUnir)==errorAnalisis.getColumna()){
                String t = temp.getLexema();
                String e = errorAnalisis.getLexema();
                temp.setLexema(t+e);
                contUnir--;
                return true;
            }
        }
        return false;
    }

    /**
     * @return the reporteFinalErrores
     */
    public ArrayList<String> getReporteFinalErrores() {
        return reporteFinalErrores;
    }
}
