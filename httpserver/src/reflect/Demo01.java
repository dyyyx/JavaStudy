package reflect;
/**
 * ��ȡ�ṹ��ϢClass����Դͷ��
 * @author 979739537
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "and";
		//Class����
		//����.getClass()
		Class<?> clz = str.getClass();
		//��.class
		clz = String.class;
		//����·��
		clz = Class.forName("java.lang.String");
	}
}
