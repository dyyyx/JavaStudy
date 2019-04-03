package col;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo1 {
	public static void main(String[] args) {
		Person p1 = new Person("ÁõµÂ»ª",1000);
		Person p2 = new Person("Áº³¯Î°",1200);
		Person p3 = new Person("ÔøÖ¾Î°",500);
		Person p4 = new Person("³ÉÁú",800);
		
		TreeMap<Person,String> persons = new TreeMap<Person,String>(
					new java.util.Comparator<Person>() {

						@Override
						public int compare(Person o1, Person o2) {
							return o1.getHandsome()-o2.getHandsome();
						}
						
					}
				);
		persons.put(p1, "666");
		persons.put(p2, "666");
		persons.put(p3, "666");
		persons.put(p4, "666");
		
		Set<Person> set = persons.keySet();
		System.out.println(set);
	}
}
