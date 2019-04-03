package com.javaob.c19;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File file1 = new File("C:\\ob\\helloworld.txt");
		File file2 = new File("words.txt");
		File file3 = new File("student.txt");
		File file4 = new File("C:\\ob");
		
		System.out.println("文件名：" + file1.getName());
		System.out.println("文件相对路径：" + file1.getPath());
		System.out.println("文件绝对路径：" + file1.getAbsolutePath());
		System.out.println("文件上级目录：" + file1.getParent());
		System.out.println("文件路径名的绝对形式：" + file1.getAbsoluteFile());
		
		System.out.println("\n文件名：" + file2.getName());
		System.out.println("文件相对路径：" + file2.getPath());
		System.out.println("文件绝对路径：" + file2.getAbsolutePath());
		System.out.println("文件上级目录：" + file2.getParent());
		System.out.println("文件路径名的绝对形式：" + file2.getAbsoluteFile());
		
		System.out.println("\n文件名：" + file3.getName());
		System.out.println("文件相对路径：" + file3.getPath());
		System.out.println("文件绝对路径：" + file3.getAbsolutePath());
		System.out.println("文件上级目录：" + file3.getParent());
	}
}
