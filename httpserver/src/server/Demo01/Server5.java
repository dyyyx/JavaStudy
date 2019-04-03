package server.Demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server5 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		
		Server5 server = new Server5();
		server.start();
		
	}
	/**
	 * ����������
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
	 * ���տͻ���
	 */
	private void receive() {
		try {
			Socket client = server.accept();
			//����
			Request req = new Request(client.getInputStream());
			
			//��Ӧ
			Response rep = new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP��Ӧʾ��</title>");
			rep.println("</head><body>");
			rep.println("��ӭ��").println(req.getParameter("uname")).println("����");
			rep.println("</body></html>");
			rep.pushToClient(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	public void stop() {
		
	}
}