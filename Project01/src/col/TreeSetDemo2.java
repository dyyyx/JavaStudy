package col;

import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		Worker w1 = new Worker("垃圾回收员",1200);
		Worker w2 = new Worker("农名工",1000);
		Worker w3 = new Worker("程序员",800);
		
		TreeSet<Worker> employees = new TreeSet<Worker>();
		employees.add(w1);
		employees.add(w2);
		employees.add(w3);
		System.out.println(employees);
	}
}
