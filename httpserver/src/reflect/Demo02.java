package reflect;

import server.Demo03.Servlet;

/**
 * ����ʵ�� ���ÿչ��� 
 * @author 979739537
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("server.Demo03.RegisterServlet");
		//���ÿչ��� ȷ���չ������
		Servlet ser = (Servlet)clz.newInstance();
		
		//return ser;
		
	}
}
