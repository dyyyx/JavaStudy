package server.Demo02;

import java.io.IOException;
import java.net.Socket;

import util.CloseUtil;

public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response rep;
	private int code = 200;
	Dispatcher(Socket client){
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
			code = 500;
			return;
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Servlet serv = Webapp.getServlet(req.getUrl());
			if(null == serv) {
				this.code = 404;
			}else {
				serv.service(req, rep);
			}
			rep.pushToClient(code);//推送到客户端
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			this.code = 500;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseUtil.closeAll(client);
	}

}
