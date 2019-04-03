package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.User;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * @author 979739537
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "bean.User";
		
		try {
			//通过反射API调用构造方法，构造对象
			Class<User> clazz = (Class<User>) Class.forName(path);
			User u = clazz.newInstance();//调用了User的无参构造方法
			System.out.println(u);
			
			Constructor<User> c = clazz.getDeclaredConstructor(String.class, int.class, int.class);
			User u2 = c.newInstance("张三", 1001, 18);
			System.out.println(u2.getName());
			
			//通过反射API调用普通方法
			User u3 = clazz.newInstance();
			Method m = clazz.getDeclaredMethod("setName", String.class);
			m.invoke(u3, "里斯");//u3.setName("里斯")；
			System.out.println(u3.getName());
			
			//通过反射API操作属性
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			//访问私有属性
			f.setAccessible(true);//属性不需要安全检查，可以直接访问
			f.set(u4, "王五");//通过反射直接写属性
			System.out.println(u4.getName());
			System.out.println(f.get(u4));//通过反射直接读属性
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
