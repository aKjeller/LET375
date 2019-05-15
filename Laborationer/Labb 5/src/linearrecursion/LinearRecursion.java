package linearrecursion;

import java.io.IOException;
/**
 * @author NN
 * @version 2019-05-
 */
public class LinearRecursion {
// A.1
    public static void reverseInput() throws IOException {
    	char c = (char)System.in.read();
    	if(c != '\n') {
    		reverseInput();
    		System.out.print(c);
    	}	
    }
        
// A.2
    public static int multiply(int m,int n) {
    	if(m == 0)
    		return 0;
    	else if(m < 0)
    		return -multiply(-m + 1,n) + n;
    	else
    		return multiply(m - 1, n) + n;
    } 
    
    
// A.3
    public static int countDigits(int n) {
    	if(n >= 10) 
       		return countDigits(n/10) + 1;
    	return 1; 
    }
           
    public static ListNode cons( int element, ListNode l ) {
        return new ListNode( element, l );
    }
    
    public static String toString( ListNode l ) {
        return "[" + toStringRec(l) + "]";
    }
    
    public static String toStringRec( ListNode l ) {
        if ( l == null )
            return "";
        else {
            return "" + l.element + 
                ((l.next == null) ? "" : "," + toStringRec(l.next));
        }
    }
    
    public static void print( String prompt, ListNode l ) {
        System.out.println(prompt + ": " + toString(l));
    }

// A.4
    public static ListNode copy( ListNode l ) {
        if(l == null)
        	return null;
        else
        	return cons(l.element,copy(l.next));
    }
    
// A.5  
	 public static ListNode append( ListNode l1, ListNode l2 ) {
	     if(l1 == null)
	     	return copy(l2);
	     else
	    	 return cons(l1.element,append(l1.next,l2));
	 }
    
/**********************************************
 * Some test cases.
 * Uncomment as you proceed!
 * ********************************************/
    public static void main(String[] args) throws IOException {
// A.1
     reverseInput();
     System.out.println();
// A.2
      System.out.println("\nTesting multiply:");
      System.out.println(multiply(5,7));
      System.out.println(multiply(-5,7));
      System.out.println(multiply(5,-7));
      System.out.println(multiply(-5,-7));
      System.out.println(multiply(0,7));
      System.out.println(multiply(5,0));
// A.3
      System.out.println("\nTesting countDigits:");
      System.out.println(countDigits(0));
      System.out.println(countDigits(5));
      System.out.println(countDigits(123));
      System.out.println(countDigits(123456789));
                
        // An array of some test lists
        ListNode[] ll = {
            null,                           // []
            cons(1,null),                   // [1]
            cons(2,cons(3,null)),           // [2,3]
            cons(4,cons(5,cons(6,null)))    // [4,5,6]
        };
        
      System.out.println("\nIn the test cases below, you should verify that"); 
      System.out.println("the ll[i] printouts are consistent with the definitions"); 
      System.out.println("of the lists in the ll array. Those lists must not be"); 
      System.out.println("changed by your functions."); 
// A.4  
      System.out.println("\nTesting copy:");    
      for ( int i = 0; i < ll.length; i++ ) {
          ListNode copy = cons(999,copy(ll[i]));
          print("cons(999,copy(ll["+i+"]))",copy);       // result
          print("ll["+i+"]",ll[i]); // original should be untouched
      }
// A.5     
         System.out.println("\nTesting append from left:"); 
         for ( int i = 0; i < ll.length - 1; i++ ) {
             ListNode appended = append(ll[i],ll[ll.length-1]);
             print("append(ll["+i+"],ll["+(ll.length-1)+"])",appended);       // result
             print("ll["+i+"]",ll[i]); // original should be untouched
             print("ll["+(ll.length-1)+"]",ll[ll.length-1]); // original should be untouched
         }
         
         System.out.println("\nTesting append from right:"); 
         for ( int i = 0; i < ll.length - 1; i++ ) {
             ListNode appended = append(ll[ll.length-1],ll[i]);
             print("append(ll["+(ll.length-1)+"],ll["+i+"])",appended);       // result
             print("ll["+(ll.length-1)+"]",ll[ll.length-1]); // original should be untouched
             print("ll["+i+"]",ll[i]); // original should be untouched
         }
    }
}
