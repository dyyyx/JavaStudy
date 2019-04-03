package com.javaob.c19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		//�����ļ�Ŀ¼
		File src = new File("C:\\ob\\helloworld.txt");
		//������
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(src);
			String msg = "TestBufferedInputOutputStream !!!";
			byte[] flush = msg.getBytes();
			fos.write(flush);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fos.flush();
				while(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
