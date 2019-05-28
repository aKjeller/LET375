package uppgift7;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
	String name;
	boolean visited = false;
	int dist = 0;
	List<Vertex> neighbours;
	
	public Vertex(String name) {
		this.name = name;
		neighbours = new LinkedList<>();
	}
	
	public String toString() {
		return name;
	}
}