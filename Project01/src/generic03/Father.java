package generic03;
/***
 * 要么同时擦除，要么子类大于等于父类的类型
 * 不能子类擦除，父类泛型
 * 1.属性类型
 * 父类中，随父类而定
 * 子类中，随子类而定
 * 2.方法重写
 * 随父类而定
 * @author 979739537
 *
 * @param <T>
 * @param <T1>
 */

public abstract class Father<T,T1> {
	T name;
	public abstract void test(T t);
	
}

class Child1 extends Father<String,Integer>{
	String t1;

	@Override
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}	
}


class Child2<T,T1> extends Father<T,T1>{
	T1 name;

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
}

//泛型的擦除，使用object替换
class Child3<T,T1> extends Father{
	T1 name;

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
}


class Child4 extends Father{
	String name;

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
}


