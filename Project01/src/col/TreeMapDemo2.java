package col;

import java.util.TreeMap;


public class TreeMapDemo2 {
	public static void main(String[] args) {
		Worker w1 = new Worker("垃圾回收员",1200);
		Worker w2 = new Worker("农名工",1000);
		Worker w3 = new Worker("程序员",800);
		
		TreeMap<Worker,String> employees = new TreeMap<Worker,String>();
		employees.put(w1,"666");
		employees.put(w2,"666");
		employees.put(w3,"666");
		System.out.println(employees.keySet());
	}
}
