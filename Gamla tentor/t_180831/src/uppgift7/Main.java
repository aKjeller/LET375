package uppgift7;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		TreeNode t = new TreeNode();
		t.element = 'A';
		t.left = new TreeNode();
		t.left.element = 'B';
		t.left.left = new TreeNode();
		t.left.left.element = 'D';
		
		t.right = new TreeNode();
		t.right.element = 'C';
		t.right.left = new TreeNode();
		t.right.left.element = 'E';
		t.right.right = new TreeNode();
		t.right.right.element = 'F';
		
		printLevelOrder(t);
	}

	public static void printLevelOrder(TreeNode t) {
		if(t == null)
			return;
		else {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(t);
			while(!list.isEmpty()) {
				TreeNode next = list.remove();
				System.out.print(next.element + " ");
				if(next.left != null)
					list.add(next.left);
				if(next.right != null)
					list.add(next.right);
			}
		}		
	}
}
