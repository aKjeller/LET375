// Author(s): Markus Gedda, Alfred Kjeller
// Version: 1.0
// Date: 2019-03-31

package uppgift2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordLists {
	private Reader in = null;
	
	File file;
	FileInputStream iS;
	String input;
	PrintWriter writer; 
	
	TreeMap<String,Integer> wordFrequencies = new TreeMap<String, Integer>();

	public WordLists(String inputFileName) {
		file = new File(inputFileName);
		try {
			in = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isPunctuationChar(char c) {
	    final String punctChars = ",.:;?!";
	    return punctChars.indexOf(c) != -1;
	}
	
	private String getWord() throws IOException {
		int state = 0;
		int i;
		String word = "";
		while ( true ) {
			i = in.read();
			char c = (char)i;
			switch ( state ) {
			case 0:
				if ( i == -1 )
					return null;
				if ( Character.isLetter( c ) ) {
					word += Character.toLowerCase( c );
					state = 1;
				}
				break;
			case 1:
				if ( i == -1 || isPunctuationChar( c ) || Character.isWhitespace( c ) )
					return word;
				else if ( Character.isLetter( c ) ) 
					word += Character.toLowerCase( c );
				else {
					word = "";
					state = 0;
				}
			}
		}
	}
	
	private String reverse(String s) {
		String reverse = "";
		
		for(int i = s.length()-1; i >= 0; i-- ) {
			reverse = reverse + s.charAt(i);
		}
	    return reverse;
	}
	
	private void computeWordFrequencies() {
          try {
        	  writer = new PrintWriter("alfaSorted.txt", "UTF-8");
        	  
        	  while((input = getWord()) != null) {
        		  if(!wordFrequencies.containsKey(input)) {
        			  wordFrequencies.putIfAbsent(input, 1);
        		  } else {
        			  wordFrequencies.put(input, wordFrequencies.get(input) + 1);
        		  }
        	  }
        	  
        	  for(Map.Entry<String,Integer> entry : wordFrequencies.entrySet()) {
        		  writer.println(entry.getKey() + "  " + entry.getValue());
        	  }
        	  
        	  writer.close();
        	    
          } catch (IOException e) {
        	  e.printStackTrace();
          }
	}
	
	private void computeFrequencyMap() {
		TreeMap<Integer,TreeSet<String>> frequencyMap = new TreeMap<Integer,TreeSet<String>>();	
		try {
			writer = new PrintWriter("frequencySorted.txt", "UTF-8");
			
			for(Map.Entry<String,Integer> entry : wordFrequencies.entrySet()) {
				if(!frequencyMap.containsKey(entry.getValue())) {
					frequencyMap.putIfAbsent(entry.getValue(), new TreeSet<String>());
					frequencyMap.get(entry.getValue()).add(entry.getKey());
				}
				else {
					frequencyMap.get(entry.getValue()).add(entry.getKey());
				}
			}
			
			for(Integer entry : frequencyMap.descendingKeySet()) {
      		  	writer.println(entry +":");
	  			for(String word : frequencyMap.get(entry)) {
	  				writer.println("	" + word);
				}    		  
			}
			writer.close();
        } catch (IOException e) {
      	  	e.printStackTrace();
        }
          
	}
	

	private void computeBackwardsOrder() {
		TreeSet<String> backwardsSet = new TreeSet<String>(new ReverseStringComparator());
		try {
			writer = new PrintWriter("backwardsSorted.txt", "UTF-8");
			
			for(String word : wordFrequencies.keySet()) {
				backwardsSet.add(word);
			}
			
			for(String word : backwardsSet) {
				writer.println(word);
			}
			
			writer.close();
        } catch (IOException e) {
      	  	e.printStackTrace();
        }
		
		
		
	}

	public static void main(String[] args) throws IOException {
		
		
		WordLists wl = new WordLists(args[0]);  // arg[0] contains the input file name
		wl.computeWordFrequencies();
		wl.computeFrequencyMap();
		wl.computeBackwardsOrder();
		
		System.out.println("Finished!");
		
	}
	
	private class ReverseStringComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return ((reverse(a)).compareTo(reverse(b)));
		}
	}
}



















