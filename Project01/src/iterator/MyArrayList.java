package iterator;

import java.util.Iterator;

public class MyArrayList {
	private String[] elem = {"a","b","c","d","e","f"};
	private int size = elem.length;
	
	//封装 便于迭代器的重复使用
	public class MyIt implements Iterator<String>{
		
	
		private int cursor = -1;
	
		public boolean hasNext() {
			return cursor+1<size;
		
		}
		public String next() {
			cursor++; 
			return elem[cursor];
		}
		public void remove() {
		
		}
	}
	
	public Iterator<String> iterator(){
		return new MyIt();
		
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
