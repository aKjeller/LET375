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
	
	public void levelOrder(String startVertex) {
		if(startVertex == null) {
			System.out.println(startVertex + " is unknown");
		}
		else {
			Queue<Vertex> q = new LinkedList<Vertex>();
			q.add(graphTable.get(startVertex));
			int level = 0;
			System.out.print(level + ": ");
			while(!q.isEmpty()) {
				Vertex v = q.poll();
				if(!v.visited) {
					if(v.dist == level + 1) {
						level++;
						System.out.print("\n" + level + ": ");
					}
					v.visited = true;
					System.out.print(v + " ");
					for(Vertex n : v.neighbours) {
						if(n.dist == 0)
							n.dist = v.dist + 1;
						q.add(n);
					}
				}
			}
		}
	}
}