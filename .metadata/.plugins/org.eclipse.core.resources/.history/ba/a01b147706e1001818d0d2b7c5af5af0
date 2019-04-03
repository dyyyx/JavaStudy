package server.Demo03;

import java.util.Map;

public class Webapp {
	private static ServletContext context;
	static {
		context = new ServletContext();
		
		Map<String, String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String, String> servlet = context.getServlet();
		servlet.put("login", "server.Demo03.LoginServlet");
		servlet.put("register", "server.Demo03.RegisterServlet");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if((null == url) || (url=url.trim()).equals("")) {
			return null;
		}
		//根据完整路径创建对象

		//return context.getServlet().get(context.getMapping().get(url));
		String name = context.getServlet().get(context.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
	}
}
