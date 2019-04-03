package com.javaob.c30;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) {
		//1.建立一个serversocket对象
		ServerSocket server = null;
		//2.创建一个socket对象，该对象负责与客户端建立联系
		Socket socket = null;
		//3.输入流对象
		InputStream is = null;
		try {
			server = new ServerSocket(9999);
			socket = server.accept();
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭资源
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(socket!=null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(server!=null) {
					server.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
