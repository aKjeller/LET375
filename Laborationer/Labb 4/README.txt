Uppgift 1: Det stämmer, gjort flera test och får samma resultat varje gång, kan skilja +-10% vid varje test. Detta beror på att andra program tar processorkraft och det kan skilja från gång till gång och beror på vilka programm körs i bakgrunden. 

Uppgift 2-4: Gjorde även en N^3 lösning ;) 

Uppgift 5: 

1.Linärsökning:
T(M,N)=O((N^2)*M) 

Binärsökning:
T(M,N)=O((N^2)*log(M)) 


      1.  for( int r = 0; r < rows; r++ )
        2.    for( int c = 0; c < columns; c++ )
          3.      for( int rd = -1; rd <= 1; rd++ )
            4.        for( int cd = -1; cd <= 1; cd++ )
                        if( rd != 0 || cd != 0 )
                            matches += solveDirection( r, c, rd, cd );
For loop 1 och 2 gör så att loop 3 körs n^2 gånger. loop 3 och 4 gör så att solveDirection körs 8 gånger. Alltså körs solveDirection 8n^2 gånger där n är storleken på matrisen. 

For loopen i SolveDirection utgår från från r och c från loop 1 och 2 och använder deltat i loop 3 och 4 för att gå i alla 8 riktningar från r och c. Där går loopen till kanten av matrisen för alla fall.
SearchAlg tillkallas varje gång i for loopen i SolveDirection. Det blir att endast loop 1 och 2 bidrar till tidskomplexiteten då de beror på matrisstorleken och har högst exponent.

Linjärsökning kollar igenom alla element i listan för att hitta det rätta, alltså blir komplexiteten M. Binärsökning använder sig utav en sorterad lista och kan därför söka binärt istället och då blir komplexiteten log(M).

2. Det bör ta 4 gånger så lång tid varje gång pusslet fördubblas. För linjärsökning så ökar sökningen med 7 gånger varje gång pusslet fördubblas i praktiken.
För Binärsökning så ökade tiden med 4 gånger varje gång pusslet fördubblades i praktiken. En av anledningarna till varför det skiljer sig är att komplexiteten inte exakt är n^2 utan dett finns skalfaktorer som gör att det tar en annan tid. 
En annan anledning till att det skiljer sig från teorin är att processorn inte endast jobbar med algoritmen utan andra program tar även kraft, detta borde dock jämna ut sig över flera tester men bidrar till att det inte var exakt 4 varje gång binärsökningen kördes utan ibland var det 4.7 tex.
