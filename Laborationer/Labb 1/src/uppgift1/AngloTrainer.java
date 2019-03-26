// Author(s):
// Email: 
// Date:	

package uppgift1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Random;


public class AngloTrainer {
	// ...
	TreeSet<String> wordlist;
	public AngloTrainer(String dictionaryFile) throws IOException {
		wordlist = new TreeSet<String>();
		loadDictionary(dictionaryFile);
		dumpDict();
	}

	// use this to verify loadDictionary
	private void dumpDict() {
	    // Print out the dictionary at the screen.
		Iterator<String> it = wordlist.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private void loadDictionary( String fileName ) {
	    // Read the dictionary into a suitable container.
	    // The file is a simple text file. One word per line.		
    	Scanner scan = null;
        File file = new File(fileName);

        try {
            scan = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
        while(scan.hasNext()){        	
            wordlist.add(scan.nextLine());       
        }
	}

	private String randomLetters( int length ) {
	    // this makes vovels a little more likely
		Random randomGenerator = new Random();
		
	    String letters = "aabcdeefghiijklmnoopqrstuuvwxyyz";  
	    StringBuffer buf = new StringBuffer(length);
	    for ( int i = 0; i < length; i++ ) 
		    buf.append( letters.charAt(randomGenerator.nextInt(letters.length())));
	
	    return buf.toString();
	}
	
	
	/* Def. includes	
	 * Let #(x,s) = the number of occurrences of the charcter x in the string s.
	 * includes(a,b) holds iff for every character x in b, #(x,b) <= #(x,a)
	 * 
	 * A neccessary precondition for includes is that both strings are sorted
	 * in ascending order.
	 */
	private boolean includes( String a, String b ) {
		if ( b == null || b.length() == 0 )
			return true;
		else if ( a == null || a.length() == 0 )
			return false;
		
		//precondition: a.length() > 0 && b.length() > 0
		int i = 0, j = 0;
		while ( j < b.length() ) {
			if (i >= a.length() || b.charAt(j) < a.charAt(i))
				return false;
			else if (b.charAt(j) == a.charAt(i)) {
				i++; j++;
			} else if (b.charAt(j) > a.charAt(i))
				i++;
		}
		//postcondition: j == b.length()
		return true;
	}
	
     // This is just for demonstration purposes.
	private void testIncludes() { 
		//                                            expected value
		System.out.println(includes("abc",""));		//t
		System.out.println(includes("","abc"));		//f
		System.out.println(includes("abc","abc"));	//t
		System.out.println(includes("abc","bcd"));	//f
		System.out.println(includes("abc","a"));	//t
		System.out.println(includes("abc","b"));	//t
		System.out.println(includes("abc","c"));	//t
		System.out.println(includes("abc","ab"));	//t
		System.out.println(includes("abc","bc"));	//t
		System.out.println(includes("abc","ac"));	//t
		System.out.println(includes("abc","abcd"));	//f
		System.out.println(includes("abc","abd"));	//f
		System.out.println(includes("abc","d"));	//f
		System.out.println(includes("",""));		//t
		System.out.println(includes("abc","ca"));	//f
		System.out.println(includes("abc","bac"));	//f
		System.out.println(includes("abc","abbc"));	//f
		System.out.println(includes("abbc","abc"));	//t
		System.out.println(includes(null,null));    //t
		System.out.println(includes(null,""));	    //t
		System.out.println(includes(null,"abc"));	//f
		System.out.println(includes("",null));		//t
		System.out.println(includes("abc",null));   //t
	}

    public static void main(String[] args) {
        // ... define!
    	System.out.println(" Test och skriv vilka engelska ord du kan bilda utav 'dahap': ");
    	try {
			AngloTrainer angloTrainer = new AngloTrainer(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}












