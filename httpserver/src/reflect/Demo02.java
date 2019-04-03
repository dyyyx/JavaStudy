package reflect;

import server.Demo03.Servlet;

/**
 * 创建实例 调用空构造 
 * @author 979739537
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("server.Demo03.RegisterServlet");
		//调用空构造 确保空构造存在
		Servlet ser = (Servlet)clz.newInstance();
		
		//return ser;
		
	}
}
