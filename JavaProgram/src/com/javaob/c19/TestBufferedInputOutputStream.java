package com.javaob.c19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferedInputOutputStream {
	public static void main(String[] args) {
		File src = new File("C:/ob/helloworld.txt");
		File dest = new File("C:/Users/97973/Desktop/hi.txt");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			byte[] flush = new byte[20];
			int len = 0;
			while(-1 != (len = bis.read(flush))) {
				bos.write(flush, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				bos.flush();
				bos.close();
				bos.close();
			} catch (IOException e) {
				System.out.println("ÎÄ¼þ¹Ø±ÕÊ§°Ü£¡");
			}
		}
		
	}
}
