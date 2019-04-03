package col;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Person p1 = new Person("���»�",1000);
		Person p2 = new Person("����ΰ",1200);
		Person p3 = new Person("��־ΰ",500);
		Person p4 = new Person("����",800);
		
		TreeSet<Person> persons = new TreeSet<Person>(
					new java.util.Comparator<Person>() {

						@Override
						public int compare(Person o1, Person o2) {
							return o1.getHandsome()-o2.getHandsome();
						}
						
					}
				);
		persons.add(p1);
		//TreeSet ���������ʱ���� �����޸�����
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		System.out.println(persons);
		
		//p1.setHandsome(-200);
		//System.out.println(persons);
	}
}
