package com.javaob.c30;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args){
		//1.�����ͻ���socket����
		Socket client = null;
		//2.��������ֽ���
		OutputStream os = null;
		try {
			client = new Socket("localhost",9999);
			os = client.getOutputStream();
			String message = "һ���û���������";
			//3.os����Ѹ��ַ�������ֽ����飬������������
			os.write(message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.�ر���Դ	
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
