package com.javaob.c30;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serever2 {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			server = new ServerSocket(9090);
			socket = server.accept();
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1) {
				String msg = new String(b, 0, len);
				System.out.print(msg);
			}
			os = socket.getOutputStream();
			String msg = "»¶Ó­ÐÂÓÃ»§";
			os.write(msg.getBytes());
			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
