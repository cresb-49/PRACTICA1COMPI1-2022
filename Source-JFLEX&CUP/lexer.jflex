package com.carlos.pruebas.lexerParser;

import com.carlos.pruebas.obj.ErrorAnalisis;
import com.carlos.pruebas.obj.Token;

import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class Lexer
%unicode
%public
%line
%column
%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    private Token anterior;
    private Token actual;
    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    private ArrayList<ErrorAnalisis> errors;
    
    public void setErrors(ArrayList<ErrorAnalisis> errors) {
        this.errors = errors;
    }

    public ArrayList<ErrorAnalisis> getErrors() {
        return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.add(error);
        System.out.println("Se decto un error");
    }
%}
%eofval{
  return new java_cup.runtime.Symbol(ParserGraphicsSym.EOF);
%eofval}


LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = [#][^\n]*
Def = def|Def
GraphicBarras = Barras
GraphicPie = Pie
Tittle = titulo
EjeX = ejex
EjeY = ejey
Label = etiquetas
Values = valores
Link = unir
Type = tipo
TypeValue = Porcentaje|Cantidad
Total = total
Extra = extra
Execute = Ejecutar
Number = [0-9]
Numbers = {Number}+
Decimal = {Numbers}[.]{Numbers}


%state STRING

%%


<YYINITIAL> {
    {Comment}       {
                        //Dont return symbol, its a coment
                    }
    {Def}           {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DEF,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Def: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {GraphicBarras} {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.GRAPHICBARRA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Grafico: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {GraphicPie} {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.GRAPHICPIE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Grafico: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Tittle}        {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.TITTLE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Titulo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {EjeX}          {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.EJEX,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Ejex: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {EjeY}          {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.EJEY,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Ejey: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Label}         {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LABEL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Etiqueta: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Values}        {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.VALUES,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Link}          {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LINK,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Union: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Type}          {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.TYPE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Tipo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {TypeValue}     {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.TYPEVALUE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Tipo Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Total}         {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.TOTAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Total: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Extra}         {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.EXTRA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Extra: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Execute}       {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.EXECUTE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Ejecutar: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Decimal}       {
                        this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DECIMAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Decimal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Numbers}       {
                        this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.NUMBERS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Numero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [*]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MUL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("*: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [/]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DIV,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("/: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [+]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MAS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [-]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MENOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [(]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [)]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CO_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]            {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CO_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [{]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LLA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LLA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DOSPUNTOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [;]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PUNTOCOMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(";-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\"]            {
                        this.stringColumnInit = (yycolumn+1);
                        this.string.setLength(0); 
                        yybegin(STRING); 
                    }
    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}
<STRING>{
    [\"]            {
                        yybegin(YYINITIAL);
                        this.actual = new Token(string.toString(),string.toString(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.STRING,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                    }
    [^\n\r\"]+      {
                        string.append(yytext());
                    }
}

[^]                 { 
                        String des ="El simbolo no existe en el lenguaje";
                        this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }