package uppgift2;

import java.util.ArrayList;
import java.util.List;

public class Section {
	private String title;
	private List<Section> subsections;
	
	public Section(String title) {
		this.title = title;
		subsections = new ArrayList<Section>();
	}
	public void add(Section m) {
		subsections.add(m);
	}
	
	public void print() {
		print(this, "1");
		System.out.println();
		print2("1");
	}
	//Min lösning
	private void print(Section s, String no) {
		System.out.println(no + " " + s.title);
		if(s.subsections.size() != 0) {
			for(int i = 1; i <= s.subsections.size(); i++) {
				print(s.subsections.get(i-1), no + "." + i);
			}
		} 
	}
	//lösning facit
	private void print2(String no) {
		System.out.println(no + " " + title);
		int i = 1;
		for(Section s : subsections)
			s.print2(no + "." + i++);
	}
}