
Anglotrainer: 
För att optimera skapade vi ett separat TreeSet som innehåller alla korrekta ord som är möjliga att skapa från de random-genererade bokstäverna. När rätt ord skrivs in så tas dem bort från den "korrekta"-setet så att vi kan smidigt printa ut det. 

WordList: 
1. Wordfrequency är skapat genom att orden läggs i en TreeMap där orden är Keys och fred är value. 
2. FrequencyMap är skapat genom att göra frequencies till keys från den gamla TreeMapen, sedan läggs orden i respektive TreeSet som läggs i respektive Value i TreeMapen. 
3. ComputeBackwards fungerar genom att inkludera en ny class som hete Reversingcomparator, som i sin tu jämför det omvända ordet med det andra omvända ordet som görs via metoden reverse. 
