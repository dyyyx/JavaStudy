package com.javaob.c30;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
		public static void main(String[] args){
		//1.建立客户端socket对象
		Socket client = null;
		//2.创建输出字节流
		OutputStream os = null;
		InputStream is = null;
		try {
			client = new Socket("localhost",9090);
			os = client.getOutputStream();
			String message = "一个用户建立连接";
			//3.os对象把该字符串变成字节数组，并发给服务器
			os.write(message.getBytes());
			os.flush();
			
			is = client.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1) {
				String msg = new String(b, 0, len);
				System.out.print(msg);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭资源	
			try {
				if(is!=null){
					is.close();		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(os!=null){
					os.close();		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(client!=null) {
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
