package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author 979739537
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("test.annotation.SxtStudent");
			//获得类所有有效注解
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations) {
				System.out.println(a);
			}
			
			//获得类的指定的注解
			SxtTable sxt = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(sxt.value());
			
			//获得类的属性的注解
			Field f = clazz.getDeclaredField("name");
			SxtField sxtField = f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName() + "--->" + sxtField.type() + "--->" + sxtField.length());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
