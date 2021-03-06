package server.Demo01;

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
		
		Servlet serv = new Servlet();
		serv.service(req, rep);
		try {
			rep.pushToClient(code);//���͵��ͻ���
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
