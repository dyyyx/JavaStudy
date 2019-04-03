package testcollection;

import java.util.HashMap;

public class MyHashSet {
	HashMap map;
	private static final Object PRESENT = new Object();
	int size;
	
	public MyHashSet() {
		map = new HashMap();
	}
	public int size() {
		return map.size();
		
	}
	public void add(Object o) {
		map.put(o, PRESENT);//set的不可重复是利用了map里面键对象的不可重复
		
	}

	public static void main(String[] args) {
		MyHashSet s = new MyHashSet();
		s.add("aaa");
		s.add(new String("aaa"));
		System.out.println(s.size());
	}
}
