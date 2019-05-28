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
			LinkedList<LinkedList<Vertex>> list = new LinkedList<LinkedList<Vertex>>();
			LinkedList<Vertex> temp = new LinkedList<Vertex>();
			temp.add(graphTable.get(startVertex));
			list.add(temp);
			
			int level = 0;
			while(!list.isEmpty()) {
				System.out.print(level + ": ");
				
				for(Vertex str: list.remove()) {
					System.out.print(str + " ");	
					list.add((LinkedList)graphTable.get(str.name).neighbours);
				}
				
					

				level++;
				System.out.println();

				
			}
		}
	}
	public void levelOrder(String startVertex) {     
		Queue<Vertex> q = new LinkedList<>();     
		q.add(graphTable.get(startVertex));     
		int dist = 0;     System.out.print(dist + ": ");     
		while ( ! q.isEmpty() ) { 
		        Vertex v = q.poll();        
		        if ( ! v.visited ) {            
		        	if ( v.dist == dist + 1 ) { // Next level                 
		        		dist++;                 
		        		System.out.print("\n" + dist + ": ");             
		        	}             
		        	System.out.print(v + " ");             
		        	v.visited = true;             
		        	for ( Vertex w : v.neighbours ) {                 
		        		if ( w.dist == 0 )                     
		        		w.dist = v.dist + 1;                
		        		q.add(w);            
		        	}    	     
		        }     
		} 	
	}
	
}