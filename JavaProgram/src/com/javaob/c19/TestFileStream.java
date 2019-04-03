package com.javaob.c19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
	public static void CopyFileWithBufferedStream(String scrPath, String destPath) throws IOException {
		File src = new File(scrPath);
		File dest = new File(destPath);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		byte[] flush = new byte[20];
		int len = 0;
		while(-1 != (len = bis.read(flush))) {
			bos.write(flush, 0, len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}
	
	
	public static void copyFile(String srcPath, String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		fis = new FileInputStream(src);
		fos = new FileOutputStream(dest);
		
		byte[] flush = new byte[20];
		int len;
		while(-1 != (len=fis.read(flush))) {
			fos.write(flush, 0, len);
		}
		
		fos.flush();	
		fos.close();
		fis.close();
		
	}
	public static void main(String[] args) {
		long timeStart = System.currentTimeMillis();
		try {
			copyFile("C:/Users/97973/Pictures/pp/IMG_0141.tif","C:/Users/97973/Desktop/pic.tif");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("字节流耗时："+(timeEnd-timeStart)/1000.0+"秒");
	
		long timeStart1 = System.currentTimeMillis();
		try {
			CopyFileWithBufferedStream("C:/Users/97973/Pictures/pp/IMG_0141.tif","C:/Users/97973/Desktop/pic.tif");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long timeEnd1 = System.currentTimeMillis();
		System.out.println("缓冲流耗时："+(timeEnd1-timeStart1)/1000.0+"秒");
	}
}
