package com.javaob.c19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		//1.����File����
		File file = new File("C:\\ob\\helloworld.txt");
		//2.����һ��FileInputStream����
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//3.read()�����������ݴ���
			int b = fis.read();
			while(b != -1) {
				System.out.print((char) b);
				b = fis.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {	
				if(null!=fis) {
					fis.close();
				}
			} catch (IOException e2) {
																																																																																																																																																																																																																																																																																																																																																																																																																												
				System.out.println("�ر��ļ�������ʧ��");
			}		
		}
		
	}
}