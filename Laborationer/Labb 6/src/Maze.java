import java.util.HashMap;
import java.util.Random;

public class Maze extends Board {
  	private Random random = new Random();
    public Maze( int rows, int cols ) {
    	super(rows,cols);
//    	 Implement this!
    }
    
	public void create() {
		HashMap<Integer, Point.Direction> soonNotWalls = new HashMap<Integer, Point.Direction>();
    	
		DisjointSets wallSet = new DisjointSets(maxCell);
		Boolean finished = false;
		while(!finished) {
			Point point2 = randomPoint();
			Point point1 = new Point(point2.row,point2.col);
			Point.Direction dirr = randomDirr(point1);
			point2.move(dirr);
			
			if(wallSet.find(getCellId(point1)) != wallSet.find(getCellId(point2))) {
				soonNotWalls.put(getCellId(point1), dirr);
				wallSet.union(wallSet.find(getCellId(point1)), wallSet.find(getCellId(point2)));				
			}
			
			for(int i = 0; i < maxCell; i++) {
				if(wallSet.find(0) != wallSet.find(i)) {
					finished = false;
					break;
				}
				finished = true;
			}
			
			
		}
		
		
		
		setChanged();
    	notifyObservers(soonNotWalls);
    }
	
	private Point randomPoint() {
		return new Point(random.nextInt(maxRow-1),random.nextInt(maxCol-1));
	}
	private Point.Direction randomDirr(Point p){
		Point.Direction res = null;
		do {
			int r = random.nextInt(4);
			if(r == 0 && p.row != 0)
				res = Point.Direction.UP;
			else if(r == 1 && p.col != maxCol)
				res = Point.Direction.RIGHT;
			else if(r == 2 && p.row != maxRow)
				res = Point.Direction.DOWN;
			else if(r == 3 && p.col != 0)
				res = Point.Direction.LEFT;
			else
				res = null;	
		}while(res == null);	
		return res;
	}
    
    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
