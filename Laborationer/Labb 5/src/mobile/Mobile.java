package mobile;

// Version: 2019-04-29
public class Mobile {
    private enum MobileType { SIMPLE, COMPOSITE }
    private MobileType type;
    private double weight;                   // Simple
    private double leftLength, rightLength;  // Composite
    private Mobile left, right;

    public Mobile( double weight ) {
        type = MobileType.SIMPLE;
        this.weight = weight;
        left = null;
        right = null;
    }

    public Mobile( Mobile left, double leftLength, Mobile right, double rightLength ) {
        type = MobileType.COMPOSITE;
        this.left = left;
        this.right = right;
        this.leftLength = leftLength;
        this.rightLength = rightLength; 
    }

    private boolean isSimple() { 
        return type == MobileType.SIMPLE; 
    }
    
    // Return the total mass of the mobile
    public double getWeight() {
        if ( isSimple() )
            return weight;
        else
            return left.getWeight() + right.getWeight();
    }  

    // Determine if the mobile is balanced
    public boolean isBalanced() {
        return isSimple() ||
        left.isBalanced() && right.isBalanced() &&
        leftLength * left.getWeight() == rightLength * right.getWeight();
    } 
    
    // Return the maximum height of the mobile
    public int getHeight() {
    	int heightLeft = 1, heightRight = 1;
    	if(this.left != null)
    		heightLeft += this.left.getHeight();
    	if(this.right != null)
    		heightRight += this.right.getHeight();	
    	return Math.max(heightLeft, heightRight);	
    }   

    // Print the leaves of the mobile
    public void flatten()  {
    	if(this.isSimple())
    		System.out.print(this.weight + " ");
    	else {
    		this.left.flatten();
    		this.right.flatten();
    	}
    }  

    //  Print a structured view of the mobile
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
    
    // Change this mobile to its mirror image
    public void mirror() {
        if(!this.isSimple()) {
        	Mobile temp = left;
        	left = right;
        	right = temp;
        	left.mirror();
        	right.mirror();
        }
    }

    //  Return a clone of this mobile
    public Mobile clone() {
        if(this.isSimple())
        	return new Mobile(this.weight);
        else 
        	return new Mobile(this.left.clone(), this.leftLength, this.right.clone(), this.rightLength);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		long temp;
		temp = Double.doubleToLongBits(leftLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		temp = Double.doubleToLongBits(rightLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (Double.doubleToLongBits(leftLength) != Double.doubleToLongBits(other.leftLength))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (Double.doubleToLongBits(rightLength) != Double.doubleToLongBits(other.rightLength))
			return false;
		if (type != other.type)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	public static void main(String[] args) {
        Mobile  m1 = new Mobile( 1 ),
        m2 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
        m = new Mobile( m1, 10, m2, 2 );

        System.out.println("Total mass: " + m.getWeight() );
        
        if ( m.isBalanced() )
            System.out.println("Balanced!");
        else
            System.out.println("Not balanced!");

        System.out.println("Height m:     " + m.getHeight() );
        
        m.flatten(); System.out.println();
        
        m.prettyPrint(); System.out.println();
        m.mirror();
        m.prettyPrint(); System.out.println();
        m.mirror();
        m.prettyPrint(); System.out.println();
        
        Mobile m22 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
        m3 = new Mobile( m1, 10, m22, 2 );
        if ( m.equals(m3) )
            System.out.println("Equal!");       // They should be!
        else
            System.out.println("Not equal!");

        Mobile c = m.clone();
        if ( c.equals(m) )
            System.out.println("Equal!");       // They should be!
        else
            System.out.println("Not equal!");

        if ( c == m )
            System.out.println("Identical!");   // They should definately not!
        else
            System.out.println("Not identical!");

    }
}
