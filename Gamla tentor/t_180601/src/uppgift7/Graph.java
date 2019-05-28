package uppgift7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {
	private Map<String,Vertex>
	graphTable = new HashMap<>();
	
	public void addVertex(String name) {
		if (!graphTable.containsKey(name))
			graphTable.put(name,new Vertex(name));
	}
	
	public void addEdge(String from,String to) {
		addVertex(from);
		addVertex(to);
		graphTable.get(from).neighbours.add(graphTable.get(to));
	}
	
	public void levelOrder2(String startVertex) {
		if(startVertex == null) {
			return;
		}
		else {

		}
	}

	
}