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
Number = 
Numbers = [0-9]+
Decimal = [0-9]+[.][0-9]+




[*]
[/]
[+]
[-]
[(]
[)]
[\[]
[\]]
[{]
[}]
[,]
[:]
[;]
[\"][^\n\r\"]+[\"]
[^]
