package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷���API����ȡ�����Ϣ��������֡����ԡ��������������ȣ�
 * @author 979739537
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "bean.User";
		
		try {
			Class clazz = Class.forName(path);
			
			//��ȡ�������
			System.out.println(clazz.getName());//��İ���+������bean.User
			System.out.println(clazz.getSimpleName());//���������User
			
			//��ȡ���Է���
			//Field[] field = clazz.getFields(); ֻ�ܻ��public��field
			Field[] fields = clazz.getDeclaredFields();
			Field f = clazz.getDeclaredField("name");
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("���ԣ�" + temp);
			}
			
			//��ȡ������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("getName", null);
			//��������вΣ�����봫�ݲ������Ͷ�Ӧ��class����
			Method m02 = clazz.getDeclaredMethod("setName", String.class);
			for(Method temp:methods) {
				System.out.println("������" + temp);
			}
			
			//��ȡ��������Ϣ
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(String.class, int.class, int.class);
			System.out.println("��ù�������" + c);
			for(Constructor temp:constructors) {
				System.out.println("��������" + temp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}