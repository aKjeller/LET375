// Author(s):
// Email: 
// Date:	

package uppgift1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Random;


public class AngloTrainer {
	// ...
	TreeSet<String> wordlist = new TreeSet<String>();
	int longestWord;
	
	public AngloTrainer(String dictionaryFile) throws IOException {
		loadDictionary(dictionaryFile);
		String randomLetters = randomLettersGenerator(longestWord);	
		System.out.println("The random letters are: " + randomLetters);
		System.out.println("Try to build as many words from these letters as you can!");
		
		try {
			Boolean failed = false;
			Scanner sc = new Scanner(System. in); 
			while(!failed) {
				String input = sc.nextLine();
				if(!includes(sortString(randomLetters),sortString(input))) {
					System.out.println("The word: " + input + " is not possible to build from the letters: " + randomLetters);
					failed = true;
				}
				else if(!wordlist.contains(input)) {
					System.out.println("Your suggestion was not found in the dictionary.");		
					failed = true;
				}		
				else {
					System.out.println("ok!");
				}
			}
			sc.close();
			throw new Exception();
	
		} catch (Exception e) {
			System.out.println("I found:");
			for(String word : wordlist) {
				if(includes(sortString(randomLetters),sortString(word))) {
					System.out.println(word);
				}
			}
		}
		
		
	}
	
	private String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
        
	}

	// use this to verify loadDictionary
	private void dumpDict() {
	    // Print out the dictionary at the screen.
		for(String w : wordlist) {
		    System.out.println(w);
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
        	String next = scan.nextLine();
        	if(next.length() > longestWord)
        		longestWord = next.length();
        	
            wordlist.add(next);       
        }
        System.out.println(wordlist.size()+ " words loaded from " + fileName);
	}

	private String randomLettersGenerator( int length ) {
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
    	try {
			AngloTrainer angloTrainer = new AngloTrainer(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}












