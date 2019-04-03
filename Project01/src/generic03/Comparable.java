package generic03;
/***
 * ·ºÐÍ½Ó¿Ú
 * @author 979739537
 *
 * @param <T>
 */
public interface Comparable<T> {
	void compare(T t);
}
class Comp implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}
	
}

class Comp1<T> implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}
	
}

class Comp2<T,T1> implements Comparable<T>{

	@Override
	public void compare(T t) {
		// TODO Auto-generated method stub
		
	}
	
}


class Comp3 implements Comparable<Integer>{

	@Override
	public void compare(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}

