package col;

import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		Worker w1 = new Worker("��������Ա",1200);
		Worker w2 = new Worker("ũ����",1000);
		Worker w3 = new Worker("����Ա",800);
		
		TreeSet<Worker> employees = new TreeSet<Worker>();
		employees.add(w1);
		employees.add(w2);
		employees.add(w3);
		System.out.println(employees);
	}
}
