package uppgift7;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge("A", "B");
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "E");
		g.addEdge("D", "C");
		g.addEdge("D", "E");
		g.addEdge("D", "F");
		g.addEdge("D", "G");
		g.addEdge("E", "H");
		g.levelOrder("B");
	}

}
