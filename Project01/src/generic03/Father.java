package generic03;
/***
 * Ҫôͬʱ������Ҫô������ڵ��ڸ��������
 * ����������������෺��
 * 1.��������
 * �����У��游�����
 * �����У����������
 * 2.������д
 * �游�����
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

//���͵Ĳ�����ʹ��object�滻
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


