package com.javaob.c19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAFile {
	public static void main(String[] args) {
		File src = new File("C:/ob/helloworld.txt");
		File dest = new File("C:/Users/97973/Desktop/hi.txt");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			byte[] flush = new byte[20];
			int len;
			while(-1 != (len=fis.read(flush))) {
				fos.write(flush, 0, len);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				fos.flush();
				if(fos!=null) {
					fos.close();
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
