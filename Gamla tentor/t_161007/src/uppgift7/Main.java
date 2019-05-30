package uppgift7;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(13);
		list.add(2);
		list.add(3);
		list.add(20);
		list.add(2);
		list.add(3);
		Mobile m = Mobile.build(list);	
		m.prettyPrint();
		System.out.println();
		m.flatten();
	}
}
