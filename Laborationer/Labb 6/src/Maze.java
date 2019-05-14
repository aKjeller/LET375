import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

public class Maze extends Board {
  	private Random random = new Random();
  	private HashMap<Integer, TreeSet<Point.Direction>> soonNotWalls = new HashMap<Integer, TreeSet<Point.Direction>>();  
    public Maze( int rows, int cols ) {
    	super(rows,cols);
//    	 Implement this!
    }
    
	public void create() {	
		int numberOfSets = maxCell;
		DisjointSets wallSet = new DisjointSets(numberOfSets);
		
		soonNotWalls.put(0,new TreeSet<Point.Direction>());
		soonNotWalls.get(0).add(Point.Direction.UP);
		soonNotWalls.get(0).add(Point.Direction.LEFT);
		
		soonNotWalls.put(maxCell-1,new TreeSet<Point.Direction>());
		soonNotWalls.get(maxCell-1).add(Point.Direction.DOWN);
		soonNotWalls.get(maxCell-1).add(Point.Direction.RIGHT);
			
		while(numberOfSets > 1) {		
			Point.Direction dirr = randomDirr();
			Point point1 = randomPoint();
			Point point2 = new Point(point1.row,point1.col);
			point2.move(dirr);
			if(isValid(point2)) {
				if(wallSet.find(getCellId(point1)) != wallSet.find(getCellId(point2))) {				
					soonNotWalls.putIfAbsent(getCellId(point1), new TreeSet<Point.Direction>());
					soonNotWalls.get(getCellId(point1)).add(dirr);				
					wallSet.union(wallSet.find(getCellId(point1)), wallSet.find(getCellId(point2)));	
					numberOfSets--;
				}
			}
		}		
		setChanged();
    	notifyObservers(soonNotWalls);
    }
	
	private Point randomPoint() {
		return new Point(random.nextInt(maxRow),random.nextInt(maxCol));
	}
	private Point.Direction randomDirr(){
			int r = random.nextInt(4);
			switch(r) {
				case 0: return Point.Direction.UP;
				case 1: return Point.Direction.RIGHT;
				case 2: return Point.Direction.DOWN;
				case 3: return Point.Direction.LEFT;
				default: return Point.Direction.UP;	
			}
	}
    
    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
