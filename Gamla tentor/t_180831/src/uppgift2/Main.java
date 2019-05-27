package uppgift2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		TreeNode t = new TreeNode();
		t.element = 'A';
		t.left = new TreeNode();
		t.left.element = 'B';
		t.left.left = new TreeNode();
		t.left.left.element = 'D';
		t.left.right = new TreeNode();
		t.left.right.element = 'E';
		t.left.right.right = new TreeNode();
		t.left.right.right.element = 'X';
		
		t.right = new TreeNode();
		t.right.element = 'C';
		t.right.left = new TreeNode();
		t.right.left.element = 'X';
		t.right.right = new TreeNode();
		t.right.right.element = 'F';

		System.out.println(findPaths(null,'E'));  	// Expected: [] 
		System.out.println(findPaths(t,'A'));   	// Expected: [""] 
		System.out.println(findPaths(t,'B'));   	// Expected: ["0"] 
		System.out.println(findPaths(t,'C'));   	// Expected: ["1"] 
		System.out.println(findPaths(t,'D'));   	// Expected: ["00"] 
		System.out.println(findPaths(t,'E'));   	// Expected: ["01"] 
		System.out.println(findPaths(t,'F'));   	// Expected: ["11"]       
		System.out.println(findPaths(t,'X'));      	// Expected: ["011","10"]   
	}
	
	
	public static List<String> findPaths(TreeNode t,char x) {
		if(t == null)
			return new ArrayList<String>();
		else {
			List<String> left = findPaths(t.left, x);
			List<String> right = findPaths(t.right, x);
			
			if(!left.isEmpty())
				addPrefix("0",left);
			if(!right.isEmpty())
				addPrefix("1", right);
			left.addAll(right);
			if(t.element == x)
				left.add("\"\"");
			return left;			
		}
	}

	private static void addPrefix(String s, List<String> l) {
		for(int i = 0; i < l.size(); i++) {
			l.set(i, l.get(i).charAt(0) + s + l.get(i).substring(1));
		}
	}
}
