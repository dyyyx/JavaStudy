package testcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TestCollection {
	public static void main(String[] args) {
		List list = new ArrayList();
		//ArrayList:底层实现是数组。查询快，修改、插入、删除慢。
		//LinkedList:底层实现是链表。查询慢，修改、插入、删除快。线程不安全，效率快。
		//Vector:线程安全，效率慢。
		
		list.add("aaa");
		list.add(new Date());
		list.add(1234);//自动装箱
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.remove(new Date());
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(1, "acccs");
		list.remove(0);
		
		
	}
}
