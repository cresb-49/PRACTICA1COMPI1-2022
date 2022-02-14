%%
%class Lexer
%standalone
%unicode
%public
%line
%column
%int

%{
    

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


%state WORD

%%

<YYINITIAL> {
    
    {vocal}                         {   
                                        vocalCont++;
                                        yybegin(WORD);
                                        System.out.println("Inicio vocal");
                                    }

    {consonant}                     {
                                        yybegin(WORD);
                                        System.out.println("Inicio consonante");
                                    }

    {numbers}                        {
                                        yybegin(WORD);
                                        System.out.println("Inicio numero");
                                        System.out.println(yytext());
                                        System.out.println("Linea: "+yyline+1+" ,Columna: "+yycolumn);
                                        this.agregarEntero(new NumerosEntero(yytext(), yyline+1, yycolumn));
                                    }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}

/* error fallback */
[^]                                     { 
                                            System.out.println("Simbolo Ilegal: "+yytext()); 
                                        }