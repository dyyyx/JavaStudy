package collection02;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		Employee e = new Employee(0301,"������",3000,"��Ŀ��","2018-10");
		Employee e2 = new Employee(0302,"����",3500,"����","2017-10");
		Employee e3 = new Employee(0303,"����",3500,"����","2016-10");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		list.add(e3);
		
		printEmployeeName(list);
	
	}
	
	public static void printEmployeeName(List<Employee> list) {
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
