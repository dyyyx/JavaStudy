package com.javaob.c19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		//创建文件目录
		File src = new File("C:\\ob\\helloworld.txt");
		//创建流
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
