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
                        System.out.println("Comentario: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Def}           {
                        System.out.println("Def: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Graphic}       {
                        System.out.println("Grafico: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Tittle}        {
                        System.out.println("Titulo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {EjeX}          {
                        System.out.println("Ejex: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {EjeY}          {
                        System.out.println("Ejey: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Label}         {
                        System.out.println("Etiqueta: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Values}        {
                        System.out.println("Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Link}          {
                        System.out.println("Union: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Type}          {
                        System.out.println("Tipo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {TypeValue}     {
                        System.out.println("Tipo Valor: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Total}         {
                        System.out.println("Total: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Extra}         {
                        System.out.println("Extra: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Execute}       {
                        System.out.println("Ejecutar: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Decimal}       {
                        System.out.println("Decimal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    {Numbers}       {
                        System.out.println("Numero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [+]             {
                        System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [-]             {
                        System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [(]             {
                        System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [)]             {
                        System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [\[]             {
                        System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [\]]             {
                        System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [{]             {
                        System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [}]             {
                        System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [,]             {
                        System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [:]             {
                        System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [;]             {
                        System.out.println(";-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }
    [\"]            {
                        this.stringColumnInit = yycolumn;
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
                        System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+yycolumn);
                    }