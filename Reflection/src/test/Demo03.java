package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.User;

/**
 * ͨ������API��̬�Ĳ�����������������������
 * @author 979739537
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "bean.User";
		
		try {
			//ͨ������API���ù��췽�����������
			Class<User> clazz = (Class<User>) Class.forName(path);
			User u = clazz.newInstance();//������User���޲ι��췽��
			System.out.println(u);
			
			Constructor<User> c = clazz.getDeclaredConstructor(String.class, int.class, int.class);
			User u2 = c.newInstance("����", 1001, 18);
			System.out.println(u2.getName());
			
			//ͨ������API������ͨ����
			User u3 = clazz.newInstance();
			Method m = clazz.getDeclaredMethod("setName", String.class);
			m.invoke(u3, "��˹");//u3.setName("��˹")��
			System.out.println(u3.getName());
			
			//ͨ������API��������
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			//����˽������
			f.setAccessible(true);//���Բ���Ҫ��ȫ��飬����ֱ�ӷ���
			f.set(u4, "����");//ͨ������ֱ��д����
			System.out.println(u4.getName());
			System.out.println(f.get(u4));//ͨ������ֱ�Ӷ�����
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}