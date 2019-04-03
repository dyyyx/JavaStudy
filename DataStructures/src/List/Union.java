package List;

public class Union {
	private String[] value;
	private int size;
	
	public Union() {
		this(10);
	}
	public Union(int size) {
		value = new String[size];
	}
	public int ListLength() {
		return value.length;
	}
	public String GetElem(int i) {
		return value[i];
	}
	public int LocateElem(String e) {
		for(int i=0; i<value.length; i++) {
			if(value[i]==e) 
				return i;
			}
		return -1;
	}
	public void addElem(String e) {
		value[size] = e;
		size++;
		if(size>=value.length) {
			int newCapacity = value.length * 2;
			String[] newList = new String[newCapacity];
			//System.arraycopy(src, srcPos, dest, destPos, length);
			for (int i=0;i<value.length;i++) {
				newList[i] = value[i];
				
			}
			value = newList;
		}
	}
	public void ListInsert(int i, String e) {
		
		if(i<size && i>=0) {
			for(int a=value.length-1; a>i; i--) {
				value[a] = value[a-1];
			}
			value[i] = e;
			size++;
		}
		else {
			return;
		}
	}
	
	public static void main(String[] args) {
		Union u1 = new Union();
		Union u2 = new Union();
		u1.addElem("A");
		u1.addElem("B");
		u1.addElem("C");
		u2.addElem("B");
		u2.addElem("C");
		u2.addElem("E");
		for(int i=0; i<u1.ListLength(); i++) {
			String e = u1.GetElem(i);
			if(u2.LocateElem(e)==-1) {
				u2.ListInsert(1, e);
			}
		}
		for(int j=0; j<u2.ListLength(); j++) {
			System.out.println(u2.GetElem(j));
		}
	}
}
