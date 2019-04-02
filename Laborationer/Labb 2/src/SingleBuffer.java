public class SingleBuffer <T> {

	private T buffer; 
	
	
	
	@SuppressWarnings("hiding")
	public T get() {
		
		
		if(buffer==null)
			return null;
		
		else {
			T obj = buffer; 
			buffer=null;
			return obj; 
		}
		
		
	}
	public boolean put(T t) {
		if(buffer==null) {
			buffer = t;
			return true; 
		}
		else {
			return false; 
		}
		
		
   
	}

}
