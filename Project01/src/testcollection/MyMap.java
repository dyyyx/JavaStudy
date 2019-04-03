package testcollection;

public class MyMap {
	MyEntry[] a = new MyEntry[999];
	int size;
	public void put (Object key, Object value) {
		MyEntry e = new MyEntry(key,value);
		a[size++] = e ;
		
	}
	public Object get(Object key) {
		for(int i=0;i<size;i++) {
			if (a[i].key.equals(key)) {
				return a[i].value;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		MyMap m = new MyMap();
		m.put("张三", new Wife("李四"));
		m.put("王五",new Wife("赵一"));
		
		Wife w = (Wife)m.get("张三");
		
		System.out.println(w.name);
		
	}
}

class MyEntry{
	Object key;
	Object value;
	public MyEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
		
	}
}