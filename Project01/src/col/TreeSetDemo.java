package col;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Person p1 = new Person("刘德华",1000);
		Person p2 = new Person("梁朝伟",1200);
		Person p3 = new Person("曾志伟",500);
		Person p4 = new Person("成龙",800);
		
		TreeSet<Person> persons = new TreeSet<Person>(
					new java.util.Comparator<Person>() {

						@Override
						public int compare(Person o1, Person o2) {
							return o1.getHandsome()-o2.getHandsome();
						}
						
					}
				);
		persons.add(p1);
		//TreeSet 在添加数据时排序 不能修改数据
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		System.out.println(persons);
		
		//p1.setHandsome(-200);
		//System.out.println(persons);
	}
}
