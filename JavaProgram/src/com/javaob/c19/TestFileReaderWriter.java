package com.javaob.c19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderWriter {
	public static void main(String[] args) {
		File fileSrc = new File("C:\\Users\\97973\\Desktop\\11\\hi.txt");
		File fileDest = new File("C:\\Users\\97973\\Desktop\\java.txt");
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(fileSrc);
			fw = new FileWriter(fileDest);
			
			char[] flush = new char[20];
			int len = 0;
			while((len=fr.read(flush)) != -1) {
				String str = new String(flush, 0, len);
				System.out.println(str);
				fw.write(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				fw.flush();
				fw.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("ÎÄ¼þ¹Ø±ÕÊ§°Ü£¡");
			}
		}
	}
}
