package mobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        // ToDo
        return 0;
    }  

    // Print the leaves of the mobile
    public void flatten()  {
        // ToDo
    }  

    //  Print a structured view of the mobile
    public void prettyPrint() {
        // ToDo
    }
    
    // Change this mobile to its mirror image
    public void mirror() {
        // ToDo
    }
    
    // Determine if this mobile equals obj
    public boolean equals( Object obj ) {
        // ToDo
        return false;
    }
    
    //  Return a clone of this mobile
    public Mobile clone() {
        // .ToDo
        return null;
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

        /* Uncomment test cases as you proceed!
        System.out.println("Height:     " + m.getHeight() );
        
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
        */
    }
}
