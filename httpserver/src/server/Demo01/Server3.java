package server.Demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server3 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		
		Server3 server = new Server3();
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
			StringBuilder sb = new StringBuilder();
			String msg = null; 
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//���տͻ��˵�������Ϣ
			String requestInfo = new String(data, 0, len).trim();
			System.out.println(requestInfo);
			
			//��Ӧ
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP��Ӧʾ��</title>" + "</head><body>Hello World!</body></html>");
			
			StringBuilder response = new StringBuilder();
			//HTTPЭ��汾��״̬���롢����
			response.append("HTTP/1.1").append(BLANK).append("404").append(BLANK).append("Not Found").append(CRLF);
			//��Ӧͷ
			response.append("Server:dyx Server/0.0.1").append(CRLF);
			response.append("Data:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
				//���ĳ��ȣ��ֽڳ���
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			
			response.append(CRLF);
			response.append(responseContext);
			
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public void stop() {
		
	}
}
