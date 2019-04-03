package com.javaob.c30;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
		public static void main(String[] args){
		//1.�����ͻ���socket����
		Socket client = null;
		//2.��������ֽ���
		OutputStream os = null;
		InputStream is = null;
		try {
			client = new Socket("localhost",9090);
			os = client.getOutputStream();
			String message = "һ���û���������";
			//3.os����Ѹ��ַ�������ֽ����飬������������
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
			//4.�ر���Դ	
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
