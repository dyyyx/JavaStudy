package com.javaob.c19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStreamWithArray {
	public static void main(String[] args) {
		//1.创建File对象
		File file = new File("C:\\ob\\helloworld.txt");
		//2.创建一个FileInputStream对象
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//3.read()方法进行数据传输
			byte[] b = new byte[20];
			int len = 0;
			while((len = fis.read(b)) != -1) {
				System.out.print(new String(b, 0, len));
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
																																																																																																																																																																																																																																																																																																																																																																																																																												
				System.out.println("关闭文件输入流失败");
			}		
		}
		
	}
}
