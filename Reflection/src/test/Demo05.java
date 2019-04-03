package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import test.annotation.SxtField;
import test.annotation.SxtTable;

/**
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 * @author 979739537
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("test.annotation.SxtStudent");
			//�����������Чע��
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations) {
				System.out.println(a);
			}
			
			//������ָ����ע��
			SxtTable sxt = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(sxt.value());
			
			//���������Ե�ע��
			Field f = clazz.getDeclaredField("name");
			SxtField sxtField = f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName() + "--->" + sxtField.type() + "--->" + sxtField.length());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}