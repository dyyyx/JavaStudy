package server.Demo04;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name, pwd)) {
			rep.println("��¼�ɹ���").println(req.getParameter("uname")).println("��ӭ����");
		}else {
			rep.println("��¼ʧ��");
		}
	}
	
	public boolean login(String name, String pwd) {
		return name.equals("dyx") && pwd.equals("1112");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
