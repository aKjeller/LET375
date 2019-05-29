package uppgift7;

import java.util.List;

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
		// Implement! }
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
		// Implement!
		return null;
	}
}