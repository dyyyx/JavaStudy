package col;

import java.util.TreeMap;


public class TreeMapDemo2 {
	public static void main(String[] args) {
		Worker w1 = new Worker("��������Ա",1200);
		Worker w2 = new Worker("ũ����",1000);
		Worker w3 = new Worker("����Ա",800);
		
		TreeMap<Worker,String> employees = new TreeMap<Worker,String>();
		employees.put(w1,"666");
		employees.put(w2,"666");
		employees.put(w3,"666");
		System.out.println(employees.keySet());
	}
}
