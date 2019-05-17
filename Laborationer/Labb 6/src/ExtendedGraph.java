import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExtendedGraph extends Graph {
	public List<Integer> getPath( int destName ) {
		 Vertex w = vertexMap.get( destName );
		 if( w == null )
			 throw new NoSuchElementException( "Destination vertex not found" );
		 else if( w.dist == INFINITY )
			 System.out.println( destName + " is unreachable" );
		 return getPath( w );
	}
	private List<Integer> getPath( Vertex dest ) {
		List<Integer> a = new ArrayList<Integer>();
		if(dest.prev != null) {
			a.addAll(getPath(dest.prev));
		}
		a.add(dest.name);
		return a;
	}
}
