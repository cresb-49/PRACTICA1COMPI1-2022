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
    StringBuffer string = new StringBuffer();
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
EjeX = ejeX
EjeY = ejeY
Label = etiquetas
Values = valores
Link = unir
Type = tipo
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
                        System.out.println("Comentario: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Def}           {
                        System.out.println("Def: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Graphic}       {
                        System.out.println("Grafico: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Tittle}        {
                        System.out.println("Titulo: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {EjeX}          {
                        System.out.println("Ejex: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {EjeY}          {
                        System.out.println("Ejey: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Label}         {
                        System.out.println("Etiqueta: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Values}        {
                        System.out.println("Valor: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Link}          {
                        System.out.println("Union: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Type}          {
                        System.out.println("Tipo: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Total}         {
                        System.out.println("Total: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Extra}         {
                        System.out.println("Extra: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Execute}       {
                        System.out.println("Ejecutar: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Decimal}       {
                        System.out.println("Simbolo: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    {Numbers}       {
                        System.out.println("Simbolo: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [+]             {
                        System.out.println("+: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [-]             {
                        System.out.println("-: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [(]             {
                        System.out.println("(: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [)]             {
                        System.out.println("): "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [\[]             {
                        System.out.println("[: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [\]]             {
                        System.out.println("]: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [{]             {
                        System.out.println("{: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [}]             {
                        System.out.println("}: "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [,]             {
                        System.out.println(",: "+yytext()+" , Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [:]             {
                        System.out.println(":-> "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [;]             {
                        System.out.println(";-> "+yytext()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [\"]            {
                        string.setLength(0); 
                        yybegin(STRING); 
                    }
    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}
<STRING>{
    [\"]            {
                        yybegin(YYINITIAL);
                        System.out.println("String: "+string.toString()+", Linea: "+yyline+", Columna: "+yycolumn);
                    }
    [^\n\r\"]+      {
                        string.append(yytext());
                    }
    \\t             {
                        string.append("\t");
                    }
    \\n             {
                        string.append("\n");
                    }
    \\r             {
                        string.append("\r");
                    }
    \\\"            {
                        string.append("\"");
                    }
    \\              {
                        string.append("\\");
                    }
}

/* error fallback */
[^]                                     { 
                                            System.out.println("Simbolo Ilegal: "+yytext()); 
                                        }