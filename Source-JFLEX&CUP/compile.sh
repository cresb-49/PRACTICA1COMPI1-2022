#! /bin/bash 
echo "STARTING JFLEX COMPILING"
jflex lexer.jflex

echo "STARTING JAVA CUP COMPILING"
cup parser.cup

echo "COPY FILES"
cp Lexer.java tmp/pruebas/src/main/java/com/carlos/pruebas/lexerParser/
cp ParserGraphics.java  tmp/pruebas/src/main/java/com/carlos/pruebas/lexerParser/
cp ParserGraphicsSym.java  tmp/pruebas/src/main/java/com/carlos/pruebas/lexerParser/

echo "DELETE TEMP FILES"
rm Lexer.java 
rm ParserGraphics.java 
rm ParserGraphicsSym.java 
