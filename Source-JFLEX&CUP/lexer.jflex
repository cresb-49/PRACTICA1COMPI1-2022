package com.carlos.android_practica1.lexer_parser;

import java.util.ArrayList;

%%
%class Lexer
%unicode
%public
%line
%column
%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    private ArrayList<ErrorAnalisis> errors = new ArrayList<>();
    
    public Lexer(ArrayList<ErrorAnalisis> errors){
        this.errors=errors;
    }

    public ArrayList<ErrorAnalisis> getLexErrors() {
        return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.add(error);
        System.out.println("Se decto un error");
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = [#][^\n]*[\n]
Def = def|Def
Graphic = Barras|Pie
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
                        System.out.println("Comentario: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Def}           {
                        System.out.println("Def: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Graphic}       {
                        System.out.println("Grafico: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Tittle}        {
                        System.out.println("Titulo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {EjeX}          {
                        System.out.println("Ejex: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {EjeY}          {
                        System.out.println("Ejey: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Label}         {
                        System.out.println("Etiqueta: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Values}        {
                        System.out.println("Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Link}          {
                        System.out.println("Union: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Type}          {
                        System.out.println("Tipo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {TypeValue}     {
                        System.out.println("Tipo Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Total}         {
                        System.out.println("Total: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Extra}         {
                        System.out.println("Extra: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Execute}       {
                        System.out.println("Ejecutar: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Decimal}       {
                        System.out.println("Decimal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Numbers}       {
                        System.out.println("Numero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [+]             {
                        System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [-]             {
                        System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [(]             {
                        System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [)]             {
                        System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]             {
                        System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]             {
                        System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [{]             {
                        System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [;]             {
                        System.out.println(";-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
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
                        System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
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