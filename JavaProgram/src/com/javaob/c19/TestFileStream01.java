package com.javaob.c19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream01 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp.dat");
		
		for(int i=1;i<=10;i++) {
			fos.write(i);
		}
		fos.close();
		
		FileInputStream fis = new FileInputStream("temp.dat");
		
		int len;
		while((len = fis.read()) !=-1 ) {
			System.out.println(len + " ");
		}
		fis.close();
	}
}
