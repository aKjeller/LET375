package uppgift2;

public class Main {

	public static void main(String[] args) {
		Section alg = new Section("Algorithms");
		alg.add(new Section("Recursive algorithms"));
		alg.add(new Section("Sorting algorithms"));
		alg.add(new Section("Correctness of algorithms"));
		
		Section c = new Section("Complexity of algorithms");
		c.add(new Section("Time Complexity"));
		c.add(new Section("Space Complexity"));
		c.add(new Section("Worst Case behaviour"));
		c.add(new Section("Average Case behaviour"));
		alg.add(c);
		
		Section ds = new Section("Data Structures");
		ds.add(new Section("Abstract data types"));
		Section lists = new Section("Lists");
		lists.add(new Section("Array based representation"));
		lists.add(new Section("Pointer based representation"));
		ds.add(lists);
		
		Section trees = new Section("Trees");
		trees.add(new Section("General trees"));
		
		Section btrees = new Section("Binary trees");
		btrees.add(new Section("Expression trees"));
		btrees.add(new Section("Huffman coding trees"));
		btrees.add(new Section("Binary search trees"));
		trees.add(btrees);
		ds.add(trees);
		
		Section algDS = new Section("Algorithms and Data Structures");
		algDS.add(alg);
		algDS.add(ds);
		algDS.print();
	}
}
