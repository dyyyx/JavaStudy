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
			StringBuilder sb = new StringBuilder();
			String msg = null; 
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//接收客户端的请求信息
			String requestInfo = new String(data, 0, len).trim();
			System.out.println(requestInfo);
			
			//响应
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应示例</title>" + "</head><body>Hello World!</body></html>");
			
			StringBuilder response = new StringBuilder();
			//HTTP协议版本、状态代码、描述
			response.append("HTTP/1.1").append(BLANK).append("404").append(BLANK).append("Not Found").append(CRLF);
			//响应头
			response.append("Server:dyx Server/0.0.1").append(CRLF);
			response.append("Data:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
				//正文长度：字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			
			response.append(CRLF);
			response.append(responseContext);
			
			
			//输出流
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
