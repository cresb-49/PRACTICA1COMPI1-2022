import java.util.ArrayList;

%%
%class Lexer
%standalone
%unicode
%public
%line
%column
%int

%{
    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    private ArrayList<Object> lexErrors = new ArrayList<>();
    
    public ArrayList<Object> getLexErrors() {
        return lexErrors;
    }

    private void addError(Object object){
        this.lexErrors.add(object);
        System.out.println("Se decto un error");
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = [#][^\n]*
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
cadena = [\"][^\"]*[\"]

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
    {cadena}        {
                        System.out.println("String: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
                    
    {WhiteSpace}    { /* ignore */ }
}

[^]                 { 
                        System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }