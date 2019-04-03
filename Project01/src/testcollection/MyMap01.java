package testcollection;

import java.util.LinkedList;

public class MyMap01 {
	LinkedList[] a = new LinkedList[999];//Map的底层结构是：数组+链表
	int size;
	
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		int x = key.hashCode()%a.length;
		if(a[x]==null) {
			LinkedList list = new LinkedList();
			a[x] = list;
			list.add(e);
			
		}else {
			LinkedList list = a[x];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e2 = (MyEntry) list.get(i);
				if(e2.key.equals(key)) {
					e2.value = value;
					return;
				}
			}
			a[x].add(e);
			
		}
	}
	
	public Object get(Object key) {
		//return a[key.hashCode()%999];
		int x = key.hashCode()%a.length;
		if(a[x]!=null) {
			LinkedList list = a[x];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e = (MyEntry) list.get(i);
				if(e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		MyMap01 m = new MyMap01();
		m.put("张三", new Wife("李四"));
		m.put("张三",new Wife("赵一"));
		
		Wife w = (Wife)m.get("张三");
		
		System.out.println(w.name);
	}

}
