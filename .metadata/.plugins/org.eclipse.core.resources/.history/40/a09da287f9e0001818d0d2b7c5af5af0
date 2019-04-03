package server.Demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server6 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		
		Server6 server = new Server6();
		server.start();
		
	}
	/**
	 * 启动服务器
	 */
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	/**
	 * 接收客户端
	 */
	private void receive() {
		try {
			Socket client = server.accept();
			Servlet serv = new Servlet();
			//请求
			Request req = new Request(client.getInputStream());
			//响应
			Response rep = new Response(client.getOutputStream());
			serv.service(req, rep);
			rep.pushToClient(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	public void stop() {
		
	}
}
