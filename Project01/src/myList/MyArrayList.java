package myList;
/**
 * 
 * @author 979739537
 *
 */

public class MyArrayList {
	private Object[] value;
	private int size;
	
	public MyArrayList() {
		//value = new Object[16];
		this(16);
	}
	public MyArrayList(int size) {
		value = new Object[size];
	}
	public void add(Object obj) {
		value[size] = obj;
		size++;
		if(size>=value.length) {
			int newCapacity = value.length * 2;
			Object[] newList = new Object[newCapacity];
			//System.arraycopy(src, srcPos, dest, destPos, length);
			for (int i=0;i<value.length;i++) {
				newList[i] = value[i];
				
			}
			value = newList;
		}
	}
	public Object get(int index) {
		if(index<0||index>size-1) {
			try {
				throw new Exception();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return value[index];
	}
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("AAA");
		list.add(new Human("Œ“"));
		list.add("cccc");
		Human h = (Human) list.get(1);
		System.out.println(h.getName());
		System.out.println(list.get(0));
	}	
}
