package uppgift2;

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
		
		print(findPaths(null,'E'));  	// Expected: [] 
		print(findPaths(t,'A'));   		// Expected: [""] 
		print(findPaths(t,'B'));   		// Expected: ["0"] 
		print(findPaths(t,'C'));   		// Expected: ["1"] 
		print(findPaths(t,'D'));   		// Expected: ["00"] 
		print(findPaths(t,'E'));   		// Expected: ["01"] 
		print(findPaths(t,'F'));   		// Expected: ["11"]       
		print(findPaths(t,'X'));      	// Expected: ["011","10"]   
	}
	
	public static void print(List<String> s) {
		for(String str : s)
			System.out.println(str);
	}
	
	public static List<String> findPaths(TreeNode t,char x){
		return null;
	}
}
