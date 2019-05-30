package uppgift7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Mobile {
	public static int ROD_LENGTH = 10;
	private enum MobileType { SIMPLE, COMPOSITE }
	private MobileType type;
	private float weight; // Simple
	private float leftLength, rightLength; // Composite
	private Mobile left, right;
	
	// Simple case
	public Mobile( float weight ) {
		type = MobileType.SIMPLE;
		this.weight = weight;
		left = right = null;
	}
	
	// Composite case.
	public Mobile(Mobile left, Mobile right) { 
		this.type = MobileType.COMPOSITE;
		this.left = left;
		this.right = right;
		this.weight = left.weight + right.weight;
		this.leftLength = ROD_LENGTH * right.weight / this.weight;
		this.rightLength = ROD_LENGTH - leftLength;	
	}
	
	// Determines if this mobile is simple.
	private boolean isSimple() {
		return type == MobileType.SIMPLE; 
	}
	
	// Returns -1 if the weight of this mobile is less than that of the
	// given mobile, 1 if its is greater, and 0 ow.
	public int compareTo(Mobile m) {
		return Float.compare(this.getWeight(), m.getWeight());
	}
	
	// Returns the total mass of the mobile.
	public float getWeight() { 
		return weight; 
	} 
	
	// Returns a balanced mobile constructed from the given weights.
	public static Mobile build(List<Integer> weights) { 
		if(weights == null || weights.isEmpty())
			return null;
		if(weights.size() == 1)
			return new Mobile(weights.get(0));		
		Collections.sort(weights);
		Mobile a = null;
		for(int i : weights) {
			if(a == null)
				a = new Mobile(i);
			else {
				Mobile b = new Mobile(i);
				a = new Mobile(a,b);		
			}	
		}	
		return a;
	}
	
    public void flatten()  {
    	if(this.isSimple())
    		System.out.print(this.weight + " ");
    	else {
    		this.left.flatten();
    		this.right.flatten();
    	}
    } 
    
    public void prettyPrint() {
    	if(this.isSimple())
    		System.out.print("(" + this.weight + ")");
    	else {
    		System.out.print("[");
    		this.left.prettyPrint();
    		System.out.print( "," + this.leftLength + "," + this.rightLength + "," );
    		this.right.prettyPrint();
    		System.out.print("]");
    	}
    }
}