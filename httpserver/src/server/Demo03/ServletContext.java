package server.Demo03;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	// Ϊÿ��servletȡһ������
	// login ---> server.Demo01.LoginServlet(LoginServlet)
	private Map<String, String> servlet;
	// url ---> login
	// /log ---> login
	// /login ----> login
	// /reg  ----> reg
	private Map<String, String> mapping;
	
	ServletContext(){
		servlet = new HashMap<String, String>();
		mapping = new HashMap<String, String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}