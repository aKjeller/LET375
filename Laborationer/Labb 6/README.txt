Vi skapar en obsever som gör att vi endast uppdaterar grafiskt när vi har gjort en förrändring i Maze-klassen och då kallar på setChanged() och 
notifyObservers() för att uppdatera det grafiskt. I observer kollar vi vilken typ av information som skickas och anväder därefter lämplig ritmetod
för att utföra det grafiskt. 

I create()-metoden i Maze-klassen har vi en Hashmaps soonNotWalls med TreeSet innuti. Där Hashmap har cellId com key och TreeSet som value. 
Treesetet består av olika directions eftersom en cell kan slå ner flera väggar. Då vi börjar med en grid av olika celler kommer vi att fylla listan 
soonNotWalls med dem väggar som skall slås ner för att labyrinten skall bli lösbar. Detta görs genom att vi kör en while-loop som körs ända tills 
det bara finns en Union som inkulderar alla celler. 

I search-metoden lägger vi till alla nerslagna väggar i en graph. Sedan använder vi oss av unweighted - metoden för att sortera graphen till kortaste 
lösningen. Sedan tillkallar vi observer med alla celler som skall prickas i och uppdaterar grafiskt via metoden fillCell(). 

