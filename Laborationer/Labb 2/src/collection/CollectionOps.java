package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.*;

public class CollectionOps {

    // Put your code for print here ... 
	public static <T> void print(Collection<T> l) {
		Iterator<T> it = l.iterator();
		
		System.out.print("[");
		while(it.hasNext()) {
			System.out.print(it.next());
			if(it.hasNext())
				System.out.print(",");
		}
		System.out.print("]");
	}
	
    // Put your code for reverse here ...
	public static <T> List<T> reverse(List<T> l){
		for(int i = 0; i < l.size()/2; i++) {
			T temp = l.get(i);
			l.set(i, l.get(l.size()-1-i));
			l.set(l.size()-1-i, temp);
		}	
		return l;		
	}
	
	public static <T> boolean less(Collection<T> c1, Collection<T> c2,Comparator<T> comp) {
		for(T e1 : c1) {
			for(T e2 : c2) {
				if(comp.compare(e1, e2) >= 0) {
					return false;
				}
			}
		}	
		return true;	
	}
        
    // Example
    public static <T,R> Collection<R> map(Function<T,R> f,Collection<T> c) {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<R> result = (Collection<R>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c )
                result.add(f.apply(x));
            return result;   
        }   
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static <T> Collection<T> filter(Predicate <T> f,Collection<T> c) {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<T> result = (Collection<T>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c )
            	if(f.test(x))
            		result.add(x);
            return result;   
        }   
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Put your code for filter here ...

}
